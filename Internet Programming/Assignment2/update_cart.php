<?php
$id = filter_input(INPUT_GET, "id");
$rental_days = filter_input(INPUT_GET, "rental_days");
if (empty($id)||empty($rental_days)) {
    return;
}
session_start();
if (!empty($_SESSION['cart']) && !empty($_SESSION['cart'][$id])) {
    $_SESSION['cart'][$id]['rental_days'] = $rental_days;
}