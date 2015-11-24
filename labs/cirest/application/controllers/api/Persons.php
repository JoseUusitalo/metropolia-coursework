<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';

class Persons extends REST_Controller {
	
	// GET method implementation for .../Persons/list
	function list_get() {

		// establish connection to MongoDB server
		$connection = new MongoClient();

		// select database
		$db = $connection->company;

		// select collection 
		$collection = $db->persons;

		// retrieve all items in collection
		$cursor = $collection->find();

		if($cursor->hasNext())
		{
    		echo json_encode(iterator_to_array($cursor));
		}	
		
		// close connection
		$connection->close();
	}
	
		function list_post($firstname, $lastname, $salary)
		{
		$connection = new MongoClient();

		$db = $connection->company;

		$collection = $db->persons;

		$cursor = $collection->insert(array("id" => 10, "first name" => $firstname, "last name" => $lastname, "salary" => (int) $salary));

    		echo "added";
		$connection->close();
		}	
		
}

?>
