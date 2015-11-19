    <?php
    class Model {
        private $file = "messages.txt";

        public function messages() {
            if (file_exists($this->file)) {
                return file($this->file);
            } else {
                return array();
            }
        }

        public function add_message($nick, $message) {
            $message = '[' . date("H:i:s") . '] ' . $nick . ": " . $message;
            file_put_contents($this->file, "{$message}\n", FILE_APPEND);
        }
    }
    ?>