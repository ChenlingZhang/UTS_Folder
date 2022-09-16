<?php
    // make a connection 
    $mysql_connection = mysqli_connect("localhost","uts","internet","uts");
    // Check database Connection 
    if(mysqli_connect_errno()){
        echo "Connect FailL: ".mysqli_connect_error();
    }
    // Sql Querry 
    $querry = "select * from film";
    // Get Querry 
    $result = mysqli_query($mysql_connection,$querry);
    while($row = mysqli_fetch_array($result) ){
        printf("%s\n\n\n\n\n\n\n\n\n%s\n\n\n\n\n\n\n\n\n%s\n\n\n\n\n\n\n\n\n%s",$row['id'],$row['name'],$row['year'],$row['director']);
        echo "<br>";
      
    }




?>