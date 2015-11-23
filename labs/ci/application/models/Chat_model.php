    <?php
    class Chat_model extends CI_Model {
        private $file = "/home/codio/workspace/web-tekniikat/labs/ci/application/models/messages.txt";

        public function get_messages() {
            if (file_exists($this->file)) {
                return file($this->file);
            } else {
                return array();
            }
        }

        public function add_message() {
			$text = $this->input->post('text');
			$nickname = $this->input->post('name');
            $message = '[' . date("H:i:s") . '] ' . $nickname . ": " . $text;
            file_put_contents($this->file, "{$message}\n", FILE_APPEND);
        }
    }
    ?>
