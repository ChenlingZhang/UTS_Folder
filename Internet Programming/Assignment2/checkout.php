<html>
    <head>
        <meta charset="UTF-8">
        <!-- StyleSheet load here-->
        <link rel="stylesheet" href="css/stylesheet.css" type="text/css" />
        <!-- JQuery load here -->
        <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <!-- JS script start here -->
        <script >
            $(function () {
            });
            function booking() {
                var first_name = $.trim($("input[name='first_name']").val());
                var last_name = $.trim($("input[name='last_name']").val());
                var email = $.trim($("input[name='email']").val());
                var address1 = $.trim($("input[name='address1']").val());
                var address2 = $.trim($("input[name='address2']").val());
                var city = $.trim($("input[name='city']").val());
                var state = $.trim($("input[name='state']").val());
                var post_code = $.trim($("input[name='post_code']").val());
                var payment_type = $.trim($("input[name='payment_type']").val());
                if (!first_name || !last_name || !address1 || !city || !state || !post_code || !payment_type) {
                    alert("Please fill in completely.");
                    return;
                }
                //var re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
                var re = /[\w\-]+\@[\w\-]+\.[\w\-]+/;
                if (!re.test(email)) {
                    alert("email is invalid.");
                    return;
                }
                $.ajax({url: 'update_cars.php',
                    type: 'get'});
                $("#form").submit();
            }
        </script> 
        <?php
        session_start();
        ?>
        <title>Checkout</title>
    </head>
    <body>
        <div class="div0">
            <div class="div6">
                <div class="div7">Hertz-uts</div>
                <div class="div8">Car Rental Center</div>
            </div>
            <div class='div1' >
                <div style="text-align: center">Check Out</div>
                <div>Customer Details and Payment</div>
                <div><span>Please fill in your details.</span><span style="color:red ">* </span><span>indicates required field.</span></div>

                <form action="receipt.php" method="POST" id="form"> 
                    <fieldset>
                        <table border="0" align='center'>
                            <colgroup>
                                <col style="background-color:gainsboro;width: 200px;text-align:left;">
                                <col style="width: 300px;">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>First Name<span style="color: red">*</span></td>
                                    <td><input type="text" name="first_name"/></td>
                                </tr>
                                <tr>
                                    <td >Last Name<span style="color: red">*</span></td>
                                    <td><input type="text" name="last_name"/></td>
                                </tr>
                                <tr>
                                    <td >Email address<span style="color: red">*</span></td>
                                    <td><input type="text" name="email"/></td>
                                </tr>
                                <tr>
                                    <td >Address Line 1<span style="color: red">*</span></td>
                                    <td><input type="text" name="address1"/></td>
                                </tr>
                                <tr>
                                    <td >Address Line 2</td>
                                    <td><input type="text" name="address2"/></td>
                                </tr>
                                <tr>
                                    <td >City<span style="color: red">*</span></td>
                                    <td><input type="text" name="city"/></td>
                                </tr>
                                <tr>
                                    <td >State<span style="color: red">*</span></td>
                                    <td><input type="text" name="state"/></td>
                                </tr>
                                <tr>
                                    <td >Post Code<span style="color: red">*</span></td>
                                    <td><input type="text" name="post_code"/></td>
                                </tr>
                                <tr>
                                    <td >Payment Type<span style="color: red">*</span></td>
                                    <td><input type="text" name="payment_type"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>
                    <input type="text" hidden="true" name="data" value="123"/>
                </form>
                <div>You are required to pay $<span name="total_price">
                        <?php
                        $total_price = 0;
                        if (!empty($_SESSION['cart'])) {
                            $cart = $_SESSION['cart'];
                            foreach ($cart as $key => $value) {
                                $total_price += ($cart[$key]['rental_days'] * $cart[$key]['price_per_day']);
                            }
                        }
                        echo $total_price;
                        ?>
                    </span></div>
                <button class="button" style='float:right' onclick="booking()">Booking</button>
                <button class="button" style='float:right' onclick="window.location.href = 'index.php'">Continue Selection</button>
            </div>
        </div>
    </body>
</html>