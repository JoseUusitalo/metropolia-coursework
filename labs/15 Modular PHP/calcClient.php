<html>
 <body>

<?php

$server = $_SERVER['HTTP_HOST'];

if (isset($_GET["action"]) && isset($_GET["radius"]) && $_GET["action"] == "getCircleArea") 
{
  $circle = file_get_contents('http://'.$server.'/15%20Modular%20PHP/calcAPI.php?action=getCircleArea&radius=' . $_GET["radius"]);
  $circle = json_decode($circle, true);
  ?>
     <p>Circle with a radius of <?php echo $circle["radius"] ?> has an area of <?php echo $circle["area"] ?>.</p>
    <a href="http://<?php echo $server?>/15%20Modular%20PHP/calcClient.php?action=getOperations" alt="operatios">Return to the operation list</a> 
  <?php
}
else
{
  $operations = file_get_contents('http://'.$server.'/15%20Modular%20PHP/calcAPI.php?action=getOperations');
  $operations = json_decode($operations, true);
  ?>
    <ul>
     <?php  foreach ($operations as $operation) { ?>
      <li>
        <a href=<?php echo "http://$server/15%20Modular%20PHP/calcClient.php?action=getCircleArea&radius=" . $operation["id"]  ?> alt=<?php echo "mathematical operation #" . $operation["id"] ?>><?php echo $operation["name"] ?></a>
      </li>
     <?php } ?>
    </ul>
  <?php
} ?>
 </body>
</html>