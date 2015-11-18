<!DOCTYPE html>
<html>
<head>
    <title>Traveling</title>
    <meta charset="utf-8">
</head>

<body>
    <?php
		$dUrbanFee = 2.80;
		$dSubUrbanFee = 4.00;
		$dLongDistanceFee = 5.50;
		$sCurrency = "€";
		
		class TravelCard {
			private $sOwner = "null";
			private $dBalance = 0.0;

			public function __contruct($sOwnerName) {
				print("New travel card. The owner is $sOwnerName.<br>");
				$this->sOwner = $sOwnerName;
				$this->dBalance = 0.0;
			}

			public function loadValue($dAmount) {
				$this->dBalance += $dAmount;
				print($this->formatValue($dAmount) . " added to travel card balance, new balance is: " . $this->getBalance() . "<br>");
			}
			
			public function getBalance() {
				return $this->formatValue($this->dBalance);
			}
			
			public function printBalance() {
					print("Current travel card balance: " . $this->getBalance() . "<br>");
			}
			
			
			public function travelWithin($sZone) {
				print($this->sOwner . " is attempting to travel ");

				switch ($sZone) {
					case "Urban":
						 print("within urban areas.<br>");
						break;
					case "SubUrban":
						 print("within suburban areas.<br>");
						 break;
					default:
						 print("long distance.<br>");
						 break;
				}

				if($this->decrementBalance($this->getFee($sZone))) {
					print("> Travel succesfull!<br>");
					$this->printBalance();
					return TRUE;
				} else {
					print("> Travel failed.<br>");
					$this->printBalance();
					return FALSE;
				}
			}
			
			private function formatValue($dValue) {
				global $sCurrency;
				return($dValue . " " . $sCurrency);
			}
			
			private function getFee($sZone) {
				global $dUrbanFee;
				global $dSubUrbanFee;
				global $dLongDistanceFee;
				global $sCurrency;
				
				print("> The cost of travel is: ");

				switch ($sZone) {
					case "Urban":
						print($this->formatValue($dUrbanFee) . "<br>");
						return $dUrbanFee;
					case "SubUrban":
						print($this->formatValue($dSubUrbanFee) . "<br>");
						return $dSubUrbanFee;
					default:
						print($this->formatValue($dLongDistanceFee) . "<br>");
						return $dLongDistanceFee;
				}
			}

			private function decrementBalance($dAmount) {
				print("> Travel card balance: " . $this->getBalance() . "<br>");
				if ($this->dBalance - $dAmount >= 0.0) {
					$this->dBalance -= $dAmount;
					return TRUE;
				}
				return FALSE;
			}
		}
	
		$myCard = new TravelCard("Jane");
		$myCard->travelWithin("Urban");
		$myCard->loadValue(9.80);
		$myCard->travelWithin("Urban");
		$myCard->travelWithin("Whatever");
		$myCard->travelWithin("SubUrban");
		$myCard->loadValue(2.50);
		$myCard->travelWithin("SubUrban");
		$myCard->loadValue(0.5);
	?>
</body>
</html>