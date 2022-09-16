<?php

//PHP Associative Arrays:
$age = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43"); 
$age['Peter'] = "38";
$age['Ben'] = "57"; 
echo "Peter is " . $age['Peter'] . " years old.<br>";
foreach($age as $x => $x_value) {
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "<br>";
}


//multidimensional arrays
$cars = array(
    array("Volvo", 22, 18),
    array("BMW",15,13),
    array("Saab",5,2),
    array("Land Rover",17,15)
);
for ($row = 0; $row < count($cars); $row++)
{
    echo "<p><b>Row number $row</b></p>";
    echo "<ul>";
    for($col=0;$col<3;$col++)
    {
        echo "<li>".$cars[$row][$col]."</li>";
    }
    echo "</ul>";
}
?>