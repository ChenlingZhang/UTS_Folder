<?php
$json_string = file_get_contents('cars.json');
$cars = json_decode($json_string, true);
session_start();
if (empty($_SESSION['cart']) ||empty($_SESSION['cart'][$id])) {
    foreach ($_SESSION['cart'] as $key => $value){
        
        $id = array_column($cars, 'id');
        $i = array_search($key,$id);
        $cars[$i]['availability'] = "N";
    }
}
$json_strings = json_encode($cars);
file_put_contents("cars.json",$json_strings);