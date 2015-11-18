<!DOCTYPE html>
<html>
<head>
    <title>Get name & age</title>
    <meta charset="utf-8" />
</head>
<body>	
	<?php
	
	$myName = "Aatu Ala-Aalto";
	$myAge = 99;
	
	function printNameAge($name, $age) {
		if ($name && $age){
			print("Hello $age year old $name!");
		}
	}
	
	function reverseString($str) {
		print(strrev($str));
	}
	
	function getPrimesTo($maxInt) {
		print("1, ");
		for ($n = 2; $n <= $maxInt; $n++) {
			for ($divisor = 2; $divisor <= $n; $divisor++) {
				if ($n % $divisor == 0) {
					if ($n != $divisor) {
						break;
					} else {
						print($n . ", ");
					}
				}
			}
		}
	}
	
	function randomWord() {
		$file = file_get_contents("http://www.webstepbook.com/words.txt");
		$lines = explode("\n", $file);
		$words = explode("	", $lines[rand(0, count($lines) - 1)]);
		return $words[0];
	}
	
	print("Name and age: ");
	printNameAge($myName, $myAge);
	
	print("<br>");
	print("Reverse string: ");
	reverseString($myName);
	
	print("<br>");
	print("Primes: ");
	getPrimesTo(100);
	print("<br>");
	print("Random word: " . randomWord());
	?>
</body>
</html>