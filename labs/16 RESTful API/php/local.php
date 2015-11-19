<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8"/>
		<title>Paikallinen palaute - Helsinki</title>
	</head>
	<body>
		Näytä paikalliset palautteet katuosoitteen lähettyvillä.
		<form action="" method="get">
			Osoite: <input type="text" name="location"/><br>
			Säde: <input type="text" name="radius"/> metriä.<br>
			<button type="submit">Submit</button>
		</form>
		<br/>
		<?php
			$server = $_SERVER['HTTP_HOST'];

			if (isset($_GET["location"]) && isset($_GET["radius"]) && !empty($_GET["location"]) && !empty($_GET["radius"])) {
				print("haetaan dataa " . $_GET["radius"] . " ja " . $_GET["location"] . ".<br>");
$urladdress = 'http://' . $server . '/16%20RESTful%20API/php/localissues.php?location=' . urlencode($_GET['location']) . '&radius=' . $_GET['radius'];
				print($urladdress . "<br>");
				$jsondata = file_get_contents($urladdress);
				$palautteet = json_decode($jsondata, true);
			}

			if(!empty($palautteet)) {
					for($i = 0; $i < count($palautteet); $i+=1) {
					print('<h4>' . $palautteet[$i][0] . '</h4>');
print('<p><strong>' . $palautteet[$i][1] . ': </strong>' . $palautteet[$i][2] . '</p>');
				}
			} else {
				print("tyhjä");
			}
		?>
	</body>
</html>