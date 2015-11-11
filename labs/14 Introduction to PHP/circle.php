<?php
	$pi = 3.14;
	$radius = 2;
	$area = $pi * $radius * $radius;
	$area2 = $_POST["radius"] * $_POST["radius"] * $pi;
	
	print("The area of a circle with a radius of $radius is $area.<br />");
	print("But the area of a circle with a radius of " . $_POST["radius"] . " is " . $area2 . "!");
?>