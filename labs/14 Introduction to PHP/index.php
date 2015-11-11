<!DOCTYPE html>
<html>
    <head><title>Minimal PHP</title></head>
    <body>  
        <?php // php-mode
		
        for ($i=1; $i<=20; $i++){      
            ?> <!-- html-mode -->
            <p>
                All day long I just write PHP
            </p>
        <?php // php-mode
        }
		$number = 0;
    	$f_number = 3.14;
		print 'Values '.$number.' and '.$f_number.'.';
        ?>  <!-- back to html-mode  -->
    </body>
</html>