<html>
    <head>
        <meta charset="UTF-8">
        <!-- StyleSheet load here-->
        <link rel="stylesheet" href="css/stylesheet.css" type="text/css" />
        <!-- JQuery load here -->
        <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <!-- JS script start here -->
        <script >
            function init() {
                //var json = sessionStorage.getItem("cart");

                $.ajax({
                    url: 'get_cart.php',
                    type: 'get',
                    success: function (json) {
                        var cart = JSON.parse(json);
                        var out = '<tr><td class="td1">Thumbnail</td><td class="td1">Vehicle</td><td class="td1">Price Per Day</td><td class="td1">Rental Days</td><td class="td1">Actions</td></tr>';
                        for (var key in cart)
                        {
                            out += '<tr><td><img src="images/' + cart[key].model + '.jpg"></td>' +
                                    '<td class="td1">' + cart[key].model_year + '-' + cart[key].brand + '-' + cart[key].model + '</td>' +
                                    '<td class="td1">' + cart[key].price_per_day + '</td>' +
                                    '<td class="td1"><input id="' + key + '" class="verify" type="text" value="' + cart[key].rental_days + '"></td>' +
                                    '<td class="td1"><button class="button" onclick="del(' + key + ')">Delete</button></td></tr>';
                        }
                        document.getElementById("cars").innerHTML = out;
                    }
                });
            }
            function del(id) {
//                var cart = sessionStorage.getItem("cart");
//                cart = JSON.parse(cart);
//                cart.splice(cart.find(item => item.id === id), 1);
//                sessionStorage.setItem("cart", JSON.stringify(cart));
                $.ajax({
                    url: 'delete_from_cart.php?id=' + id,
                    type: 'get',
                    success: function () {
                        init();
                    }
                });
            }
            function checkout() {
                //var cart = sessionStorage.getItem("cart");
                $.ajax({
                    url: 'get_cart.php',
                    type: 'get',
                    success: function (json) {
                        if (json !== "{}") {
                            var cart = JSON.parse(json);
                            var val = 0;
                            var verify = true;
                            $('.verify').each(function () {
                                val = $(this).val();
                                if (val % 1 !== 0 || val <= 0) {
                                    $(this).val("");
                                    verify = false;
                                }
                            });
                            if (verify) {
                                for (var key in cart) {
                                    var rental_days = $("#" + key).val();
                                    $.ajax({
                                        url: 'update_cart.php?id=' + key + '&rental_days=' + rental_days,
                                        type: 'get',
                                        success: function () {
                                            window.location.href = 'checkout.php';
                                        }
                                    });
                                }
                                return;
                            } else {
                                alert("Intput an integer greater than 0.");
                                return;
                            }
                        }
                        alert("No car has been reserved");
                        window.location.href = 'index.php';
                    }
                });
            }
        </script>
        <?php ?>
        <title>cart</title>
    </head>
    <body onload='init()'>

        <div class="div0">
            <div style='background-color: black;width:1010px;height: 50px;top:0px;position: fixed;'>
                <div style="float: left;background-color: white;color:goldenrod;width: 10%; height: 45px;text-align: center;line-height: 45px;">Hertz-uts</div>
                <div style="position: absolute;color:#ffffff;background-color: black;height: 50px;width: 75%;font-size: 18px;margin-left: 10%;text-align: center;line-height: 50px;">Car Rental Center</div>
            </div>
            <div class='div1' >
                <table align='center' border=1 width='800px' id="cars">
                </table>
                <button class="button" style='float:right' onclick="checkout()">Proceeding to CheckOut</button>
            </div>

        </div>
    </body>
</html>