<html>
    <head>
        <meta charset="utf-8">
        <title>check out</title>
        <style>
            .error {
                width: 200px;
                height: 30px;
                color: #FF0000;
            }
        </style>
        <?php
        session_start();
        ?>
    </head>
    <body>
        <?php
        ini_set("error_reporting", "E_ALL & ~E_NOTICE");
        if (filter_input(INPUT_SERVER, "REQUEST_METHOD") == "POST") {


            if (!empty($_SESSION['cart'])) {
                $total_price = 0;

                $cart = $_SESSION['cart'];
                echo "<table border=1 align='center'>";
                echo "<tr>";
                echo "<td colspan='3' align='center'>Shopping List</td>";
                echo "</tr>";
                echo "<tr>";
                echo "<td>Product Name</td>";
                echo "<td>Product Price</td>";
                echo "<td>Product Quality</td>";
                echo "</tr>";

                foreach ($cart as $Key => $droduct) {
                    echo "<tr>";
                    foreach ($droduct as $Key => $value) {
                        if ($Key != 'product_stock') {
                            echo "<td id='$Key'>" . $value . "</td>";
                        }
                    }
                    echo "</tr>";
                    $total_price += $droduct["product_price"] * $droduct['product_quality'];
                }
                echo "<td colspan='3' align='right'>Total Price:" . $total_price . "</td></table>";
            } else {
                echo "<script>alert('no products');window.location.href='main.php';</script>";
                exit();
            }
            if (!empty(filter_input(INPUT_POST, "purchase"))) {
                $verify = true;
                if (empty(filter_input(INPUT_POST, "name"))) {
                    $nameErr = "name cannot be empty!";
                    $verify = false;
                } else {
                    $name = filter_input(INPUT_POST, "name");
                }
                if (empty(filter_input(INPUT_POST, "address"))) {
                    $addressErr = "address cannot be empty!";
                    $verify = false;
                } else {
                    $address = filter_input(INPUT_POST, "address");
                }
                if (empty(filter_input(INPUT_POST, "suburb"))) {
                    $suburbErr = "suburb cannot be empty!";
                    $verify = false;
                } else {
                    $suburb = filter_input(INPUT_POST, "suburb");
                }
                if (empty(filter_input(INPUT_POST, "state"))) {
                    $stateErr = "state cannot be empty!";
                    $verify = false;
                } else {
                    $state = filter_input(INPUT_POST, "state");
                }
                if (empty(filter_input(INPUT_POST, "country"))) {
                    $countryErr = "country cannot be empty!";
                    $verify = false;
                } else {
                    $country = filter_input(INPUT_POST, "country");
                }
                if (empty(filter_input(INPUT_POST, "email"))) {
                    $emailErr = "email cannot be empty!";
                    $verify = false;
                } else {
                    $email = filter_input(INPUT_POST, "email");
                }
                if ($verify) {
                    $connection = mysqli_connect("aaevhh7k1apu8c.cuyptwuj6hq0.us-east-1.rds.amazonaws.com", "uts", "internet", "assignment1");
                    if (mysqli_connect_errno()) {
                        die("Connect Error Message: " . mysqli_connect_error());
                    }
                    foreach ($cart as $Key => $droduct) {
                        $sql = "update products set in_stock=" . ($droduct["product_stock"] - $droduct["product_quality"]) . " where product_id=" . $Key . ";";

                        $retval = mysqli_query($connection, $sql);
                        if (!$retval) {
                            die(mysqli_error($connection));
                        }
                    }
                    mysqli_close($connection);
                    session_destroy();
                    echo "<script>alert('Checkout Success!!!');window.location.href='main.php';</script>";
                    exit();
                }
            }
        }
        ?>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="POST"> 
            <p style="text-align: center">name:<input type="text" name="name" value="<?php echo $name; ?>"/><span class="error">* <?php echo $nameErr; ?></span><br></p>
            <p style="text-align: center">address:<input name="address" type="text" value="<?php echo $address; ?>" style="text-align: center"/><span class="error">* <?php echo $addressErr; ?></span><br></p>
            <p style="text-align: center">suburb:<input type="text" name="suburb" value="<?php echo $suburb; ?>" style="text-align: center"/><span class="error">* <?php echo $suburbErr; ?></span><br></p>
            <p style="text-align: center">state:<input type="text" name="state" value="<?php echo $state; ?>" style="text-align: center"/><span class="error">* <?php echo $stateErr; ?></span><br></p>
            <p style="text-align: center">country:<input type="text" name="country" value="<?php echo $country; ?>" style="text-align: center"/><span class="error">* <?php echo $countryErr; ?></span><br></p>
            <p style="text-align: center">email:<input type="text" name="email" value="<?php echo $email; ?>" style="text-align: center"/><span class="error">* <?php echo $emailErr; ?></span><br></p>
            <p style="text-align: center"><input name= "purchase" type="submit" value="Purchase"/></p>
        </form>


    </body>

