<?php

if (isset($_GET['location']) && isset($_GET['radius'])) {
  
	$address = $_GET['location'] . ", Helsinki, Suomi";
  $maps_url = 'https://maps.googleapis.com/maps/api/geocode/json?address=' . urlencode($address);
  $maps_json = file_get_contents($maps_url);
  $maps_array = json_decode($maps_json, true);
  
	$lat = $maps_array['results'][0]['geometry']['location']['lat'];
	$long = $maps_array['results'][0]['geometry']['location']['lng'];
	
  $palaute_url = 'https://asiointi.hel.fi/palautews/rest/v1/requests.json?lat=' . $lat . '&long=' . $long . '&radius=' . urlencode($_GET['radius']);
  $palaute_json = file_get_contents($palaute_url);
  $palaute_array = json_decode($palaute_json, true);
	$stuff = array();
	for($i = 0; $i < count($palaute_array); $i+=1) {
			$desc = $palaute_array[$i]['description'];
			$add = "Ei osoitetta";
			if (!empty($palaute_array[$i]['address'])) {
					$add = $palaute_array[$i]['address'];
				}	
			$type = $palaute_array[$i]['service_name'];        
			array_push($stuff, array($add, $type, $desc));
		}
}
exit(json_encode($stuff));
?>