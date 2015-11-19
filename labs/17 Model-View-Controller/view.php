 <!DOCTYPE html> 
    <html>
    <head>
        <title>Chat</title>
    </head>
    <body>
        <h1>Chat</h1>
        <?php
        if (empty($this->messages)) {
            echo "There are no messages in the chat...";
        } else {
            foreach ($this->messages as $message) {
                echo htmlspecialchars($message) . "<br>";
            }
        }
        ?>
    <h2>New message</h2>
        <form action="?action=send" method="post">
        Nick: <input type="text" name="nick" value="<?php print($this->nick); ?>"><br>
        Message: <input type="text" name="message"><br>
        <input type="submit" value="Send">
        </form>
    </body>
    </html>