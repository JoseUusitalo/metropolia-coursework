<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8"/>
		<title>Lucky Number and Word</title>
	</head>
	<body>
		<form action="" method="">
			<button type="submit">Get Lucky!</button>
		</form>
		<br/>
		<?php
			$server = $_SERVER['HTTP_HOST'];

			$urladdress = 'http://' . $server . '/16_API/lucky/';
			$jsondata = file_get_contents($urladdress);
			$luckyArray = json_decode($jsondata, true);
			print("Number: " . $luckyArray['number']);
			print("<br>");
			print("Word: " . $luckyArray['word']);
		?>
	</body>
</html>