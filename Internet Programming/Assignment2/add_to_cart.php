<?php
$id = filter_input(INPUT_GET, "id");
if(empty($id)){return;}
$json_string = file_get_contents('cars.json');
$cars = json_decode($json_string, true);
session_start();
foreach ($cars as $key => $value) {
    if ($value['id'] == $id) {
        if ($value['availability'] == "Y") {
            $rental_days = filter_input(INPUT_GET, "rental_days");
            $price_per_day = filter_input(INPUT_GET, "price_per_day");
            $model_year = filter_input(INPUT_GET, "model_year");
            $brand = filter_input(INPUT_GET, "brand");
            $model = filter_input(INPUT_GET, "model");
            
            if (empty($_SESSION['cart']) ||empty($_SESSION['cart'][$id])) {
                $_SESSION['cart'][$id] = array(
                    "rental_days" => $rental_days, 
                    "price_per_day" => $price_per_day,
                    "model_year"=>$model_year,
                    "brand"=>$brand,
                    "model"=>$model
                    );
            } else {
                $_SESSION['cart'][$id]['rental_days'] += $rental_days;
            }
            echo "Add to the cart successfully.";
            return;
        }
        break;
    }
}
echo "Sorry, the car is notavailable now. Please try other cars.";