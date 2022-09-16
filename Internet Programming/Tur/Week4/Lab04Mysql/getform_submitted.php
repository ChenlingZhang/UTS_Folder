<?php
    $made_Before = $_GET['Before'];
    $made_After = $_GET['After'];
    $sql_Connection = mysqli_connect("localhost","uts","internet","uts");
    if(mysqli_connect_errno()){
        print("Connection Fail".mysqli_connect_error());
    }
    $sql_query = "select * from film where year>=".$made_After." "."and year<=".$made_Before;
    $result = mysqli_query($sql_Connection,$sql_query);
    if($result == null){
        print("There has no data match");
    }
    else{
        while($row = mysqli_fetch_array($result)){
            printf("%s\n\n\n\n\n\n\n\n\n%s\n\n\n\n\n\n\n\n\n%s\n\n\n\n\n\n\n\n\n%s",$row['id'],$row['name'],$row['year'],$row['director']);
            echo "<br>";
        }
    }

?>