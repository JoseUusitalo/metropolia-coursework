<?php

function getCircleArea($radius)
{
  $circle = array();

  $circle = array("radius" => "$radius", "area" => $radius*$radius*pi()); 

  return $circle;
}

function getOperations()
{
  $opList = array(array("id" => 1, "name" => "Calculate circle area")); 

  return $opList;
}

$possible_url = array("getOperations", "getCircleArea");

$value = "An error has occurred";

if (isset($_GET["action"]) && in_array($_GET["action"], $possible_url))
{
  switch ($_GET["action"])
    {
      case "getOperations":
        $value = getOperations();
        break;
      case "getCircleArea":
        if (isset($_GET["radius"]))
          $value = getCircleArea($_GET["radius"]);
        else
          $value = "Missing argument";
        break;
    }
}
exit(json_encode($value));
?>