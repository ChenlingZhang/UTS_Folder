<?
$link = mysql_connect('localhost','uts','internet','uts');
$query = 'select * from film';
$result = mysql_query($query);
$num_rows = mysql_num_rows($result);
$retrive_array = mysql_fetch_row($result);
$count = 1;
foreach($retrive_array as $film){
    while($count!=$num_rows){
        echo $count $film;
    }
}
?>