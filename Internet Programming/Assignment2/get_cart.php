<?php
session_start();
$id = filter_input(INPUT_GET, "id");
if (!empty($_SESSION['cart'])) {
    if (empty($id)) {
        echo json_encode($_SESSION['cart']);
    } else {
        echo json_encode($_SESSION['cart'][$id]);
    }
} else {
    echo "{}";
}