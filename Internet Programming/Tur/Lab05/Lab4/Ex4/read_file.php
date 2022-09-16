<?php

$datafile = "uts.txt";
//make the file permission of uts.txt to 666

//options to open the file
/*
r 	Open a file for read only
w 	Open a file for write only Erases the contents of the file or creates a new file if it doesn't exist.
a 	Open a file for write only. The existing data in file is preserved. 
r+ 	Open a file for read/write. File pointer starts at the beginning of the file
x+ 	Creates a new file for read/write. Returns FALSE and an error if file already exists
*/
$fp = fopen($datafile, "a") or die("Unable to open file for writing!");;
$date_info = date("d/m/y G:i:s",time());
 
//Write 
//The fwrite() function is used to write to a file.
fwrite($fp, $date_info."\n");
fclose($fp);

//Read from File
/*
The fgets() function is used to read a single line from a file.
*/
echo "Display the first line in the file<br>";
$myfile = fopen($datafile, "r") or die("Unable to open file!");
echo fgets($myfile);
fclose($myfile);
  
//End-Of-File - feof()
//The feof() function checks if the "end-of-file" (EOF) has been reached.

echo "<br>Display all the lines in the text file<br>";
$myfile = fopen($datafile, "r") or die("Unable to open file!");
// Output one line until end-of-file
while(!feof($myfile)) {
    echo fgets($myfile) . "<br>";
}
fclose($myfile);
?>

<html>
<head></head>
<body>
Your access of this page has been recorded!
</body>
</html>