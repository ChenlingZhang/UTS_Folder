<html>
    <head>
        <meta charset="UTF-8">
        <!-- StyleSheet load here-->
        <link rel="stylesheet" href="css/stylesheet.css" type="text/css" />
        <!-- JQuery load here -->
        <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <!-- JS script start here -->
        <script >
        </script> 
        <?php
        session_start();
        $first_name = filter_input(INPUT_POST, "first_name");
        $last_name = filter_input(INPUT_POST, "last_name");
        $email = filter_input(INPUT_POST, "email");
        $address1 = filter_input(INPUT_POST, "address1");
        $address2 = filter_input(INPUT_POST, "address2");
        $city = filter_input(INPUT_POST, "city");
        $state = filter_input(INPUT_POST, "state");
        $post_code = filter_input(INPUT_POST, "post_code");
        $payment_type = filter_input(INPUT_POST, "payment_type");
        ?>
        <title>Receipt</title>
    </head>
    <body>
        <div class="div0">
            <div class="div6">
                <div class="div7">Hertz-uts</div>
                <div class="div8">Car Rental Center</div>
            </div>
            <div class='div1' >
                <div style="text-align: center">Receipt</div>
                <table border="1" align='center' width="800px">
                    <tr>
                        <td>First Name:</td>
                        <td><?php echo $first_name; ?></td>
                    </tr>
                    <tr>
                        <td >Last Name:</td>
                        <td><?php echo $last_name; ?></td>
                    </tr>
                    <tr>
                        <td >Email address:</td>
                        <td><?php echo $email; ?></td>
                    </tr>
                    <tr>
                        <td >Address Line 1:</td>
                        <td><?php echo $address1; ?></td>
                    </tr>
                    <tr>
                        <td >Address Line 2:</td>
                        <td><?php echo $address2; ?></td>
                    </tr>
                    <tr>
                        <td >City:</td>
                        <td><?php echo $city; ?></td>
                    </tr>
                    <tr>
                        <td >State:</td>
                        <td><?php echo $state; ?></td>
                    </tr>
                    <tr>
                        <td >Post Code:</td>
                        <td><?php echo $post_code; ?></td>
                    </tr>
                    <tr>
                        <td >Payment Type:</td>
                        <td><?php echo $payment_type; ?></td>
                    </tr>
                </table>
                <table border="1" align='center' width="800px">
                    <tr>
                        <td class="td1">Thumbnail</td>
                        <td class="td1">Vehicle</td>
                        <td class="td1">Price Per Day</td>
                        <td class="td1">Rental Days</td>
                        <td class="td1">Price</td>
                    </tr>
                    <?php
                    $total_price = 0;
                    if (!empty($_SESSION['cart'])) {
                        $cart = $_SESSION['cart'];
                        foreach ($cart as $key => $value) {
                            $price = ($cart[$key]['rental_days'] * $cart[$key]['price_per_day']);
                            echo '<tr><td class="td1"><img style="width: 64px;height: 42px;" src="images/' . $cart[$key]['model'] . '.jpg"></td>' .
                                    '<td class="td1">' . $cart[$key]['model_year'] . '-' . $cart[$key]['brand'] . '-' . $cart[$key]['model'] . '</td>' .
                                    '<td class="td1">' . $cart[$key]['price_per_day'] . '</td>' .
                                    '<td class="td1">' . $cart[$key]['rental_days'] . '</td>' .
                                    '<td class="td1">$' . $price . '</td></tr>';
                            $total_price += (float)$price;
                        }
                        echo "<tr><td colspan='5' align='right'>Total Price:$" . $total_price . "</td></tr></table>";
                    }
                    ?>
                </table>
                <button class="button" style='float:right' onclick="window.location.href = 'index.php'">Continue Selection</button>
            </div>
        </div>
    </body>
</html>