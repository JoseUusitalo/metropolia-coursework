<!DOCTYPE html>
<html>

<head>
    <title>Images</title>
    <meta charset="utf-8">
</head>

<body>
    <?php 
		for ($y=0; $y<2; $y++)
		{
	?>
		<div style="clear: both">
			<?php
				for ($x=0; $x<2; $x++)
				{
			?>
				<figure style="float: left">
					<img src="../04 Introduction to CSS3/img/computer.png" alt="A computer with a monitor" />
				</figure>
			<?php
				}
			?>
		</div>
	<?php
		}
	?>
</body>
</html>