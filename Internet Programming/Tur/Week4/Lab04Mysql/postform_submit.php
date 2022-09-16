<!DOCTYPE html>
<html>
    <head>
        <title>
            PostForm_Submit
        </title>
    </head>
    <body>
        Hello! <?php echo $POST["name"]; ?>
        <p></p>
        You like move <b><?php echo $POST["moive"]; ?></b><br>
        You are enrolled into <?php echo $POST["degree"];?><br>
        Your gender is <?php echo $POST["gender"]?><br>
        Your favourite subject is <?echo $POST["favourite"]?>
        </body>
</html>