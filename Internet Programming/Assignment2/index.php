<html>
    <head>
        <meta charset="UTF-8">
        <!-- StyleSheet load here-->
        <link rel="stylesheet" href="css/stylesheet.css" type="text/css" />
        <!-- JQuery load here -->
        <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <!-- JS script start here -->
        <script >
            var g_cars;
            function loadJSON() {
                $.ajax({
                    url: 'cars.json',
                    type: 'get',
                    success: function (cars) {
                        g_cars = cars;
                        var out = "";
                        cars.forEach((item) => {
                            out += '<div class="div2">' +
                                    '<img id="image" src="images/' + item.model + '.jpg" ">' +
                                    '<div class="div3">' +
                                    '<div ><div class="div4">mileage:</div><div class="div5">' + item.mileage + 'kms</div> </div>' +
                                    '<div ><div class="div4">fuel type:</div><div class="div5">' + item.fuel_type + '</div> </div>' +
                                    '<div ><div class="div4">seats:</div><div class="div5">' + item.seats + '</div> </div>' +
                                    '<div ><div class="div4">price per day:</div><div class="div5">' + item.price_per_day + '</div> </div>' +
                                    '<div ><div class="div4">availability:</div><div class="div5">' + item.availability + '</div> </div>' +
                                    '<div ><div class="div4">description:</div><div class="div5">' + item.description + '</div> </div>' +
                                    '<button type="button" onclick="add_to_cart(' + item.id + ')" class="button">Add to Cart</button></div></div>';
                        });
                        document.getElementById("cars").innerHTML = out;
                    }
                });
            }
            function add_to_cart(id) {
                if (g_cars.find(item => item.id === id).availability === 'N') {
                    alert("Sorry, the car is notavailable now. Please try other cars.");
                } else {
                    var car = g_cars.find(item => item.id === id);
                    $.ajax({
                        url: 'add_to_cart.php?id=' + id +
                                '&model_year=' + car.model_year +
                                '&brand=' + car.brand +
                                '&model=' + car.model +
                                '&price_per_day=' + car.price_per_day +
                                '&rental_days=1',
                        type: 'get',
                        success: function (data) {
                            alert(data);
                        }
                    });
                }
            }
        </script> 
        <?php
        ?>
        <title>Car Rental Center</title>
    </head>
    <body onload='loadJSON()'>
        <div class="div0">
            <div class="div6" style=''>
                <div class="div7" style="">Hertz-uts</div>
                <div class="div8" style="">Car Rental Center</div>
                <div style=' float: right;width: 15%; height: 50px;'>
                    <button style="" type='button' class='button' onclick="javascrtpt:window.location.href = 'cart.php'">Car Reservation</button>
                </div>
            </div>
            <div class='div1' id="cars">
            </div>
        </div>
    </body>
</html>
