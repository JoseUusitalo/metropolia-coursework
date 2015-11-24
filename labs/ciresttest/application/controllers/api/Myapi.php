<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';

class Myapi extends REST_Controller {

    function __construct()
    {
        // Construct the parent class
        parent::__construct();

        // Configure limits on our controller methods
        // Ensure you have created the 'limits' table and enabled 'limits' within application/config/rest.php
        $this->methods['user_get']['limit'] = 500; // 500 requests per hour per user/key
        $this->methods['user_post']['limit'] = 100; // 100 requests per hour per user/key
        $this->methods['user_delete']['limit'] = 50; // 50 requests per hour per user/key
    }
	
    public function persons_get()
    {
		$this->response("Getting list of persons", REST_Controller::HTTP_OK);
    }
	
    public function persons_delete()
    {
		$this->response("Deleting all persons", REST_Controller::HTTP_OK);
    }
	
    public function person_get()
    {
		$person = "Getting person: " . $this->get('id');
		$this->response($person, REST_Controller::HTTP_OK);
    }
	
    public function person_delete()
    {
		$person = "Deleting person: " . $this->get('id');
		$this->response($person, REST_Controller::HTTP_OK);
    }

    public function person_post($id, $firstname, $lastname)
    {
		$data = [
			'id' => (int) $id,
            'first' => $firstname,
            'last' => $lastname
        ];
		
		$this->response($data, REST_Controller::HTTP_OK);
    }
}
