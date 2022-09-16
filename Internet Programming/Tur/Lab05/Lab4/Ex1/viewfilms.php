<?php

//Procedural style
$connection = mysqli_connect('localhost', 'uts', 'internet', 'lab4');
 

$made_after = $_REQUEST['earliest_made'];
$made_before = $_REQUEST['latest_made'];

$query_string = "select * from films where (year >= $made_after and year <= $made_before)";
 
$result = mysqli_query($connection, $query_string);
 
$num_rows = mysqli_num_rows($result);
echo "Displaying the results using associative array"

// using associative array
// mysql_fetch_assoc: This function will return a row as an associative array where the column names will be the keys storing corresponding value.
if ($num_rows > 0 ) {
    print "<table border='0'>";
    
	// write the code here to get values using associative array
    print "</table>";
}
 
mysqli_close($link;


?>