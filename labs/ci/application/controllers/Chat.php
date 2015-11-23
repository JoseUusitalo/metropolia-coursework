    <?php
    class Chat extends CI_Controller {
        private $model;

        public function __construct() {
            parent::__construct();
            $this->load->model('chat_model');
        }

		public function index()
		{	
			$data['messages'] = $this->chat_model->get_messages();
			$data['title'] = 'Chat!';

			$this->load->view('templates/header', $data);
			$this->load->view('chat/index', $data);
			$this->load->view('templates/footer');
		}

	public function write()
	{
    	$this->load->helper('form');
		$this->load->library('form_validation');

		$data['title'] = 'Create a chat message';

		$this->form_validation->set_rules('name', 'Nickname', 'required');
		$this->form_validation->set_rules('text', 'Message', 'required');

		if ($this->form_validation->run() === FALSE)
		{
			$this->load->view('templates/header', $data);
			$this->load->view('chat/write');
			$this->load->view('templates/footer');
		}
		else
		{
			$this->chat_model->add_message();
			$this->load->view('chat/success');
		}
	}
}