<?php
$id = filter_input(INPUT_GET, "id");
if(empty($id)){return;}
session_start();
unset($_SESSION['cart'][$id]);