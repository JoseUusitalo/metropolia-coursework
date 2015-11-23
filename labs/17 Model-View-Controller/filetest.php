
<?php
$filename = '/home/codio/workspace/web-tekniikat/labs/17 Model-View-Controller/filetest.php';

if (file_exists($filename)) {
    echo "The file $filename exists<br>";
} else {
    echo "The file $filename does not exist<br>";
}
echo getcwd() . "\n";
?>
