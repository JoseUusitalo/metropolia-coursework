    <?php
    class Controller {
        private $model;

        public function __construct() {
            $this->model = new Model();
        }

        public function list_it() {
            $this->messages = $this->model->messages();
			$this->nick = urldecode($_GET['nick']);
            include("view.php");
        }

        public function send() {
			$nick = $_POST["nick"];
            $this->model->add_message($nick, $_POST["message"]);
			$urlnick=urlencode($nick);
            header("Location: chat.php?action=list_it&nick=$urlnick");
        }
    }
    ?>