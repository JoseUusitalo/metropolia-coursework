    <?php
    include("model.php");
    include("controller.php");

    $controller = new Controller();
    if (isset($_GET["action"])) {
        $action = $_GET["action"];
    } else {
        $action = "list_it";
    }
    $controller->$action();
    ?>