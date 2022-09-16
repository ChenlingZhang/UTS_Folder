<!DOCTYPE html>
<html>
    <head>
        <title>PostForm</title>
    </head>
    
    <body>
        <form method="post" action = "PostForm.php">
            <table>
                <tr>
                    <td>My name is:</td>
                    <td>
                        <input type="text" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>My favourite move is: </td>
                    <td>
                        <input type="text" name="moive"/>
                    </td>
                </tr>
                <tr>
                    <td>My degree is: </td>
                    <td>
                        <select name="degree">
                            <option>
                                Bachelor
                            </option>
                            <option>
                                Master
                            </option>
                            <option>
                                Ph.D
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td>
                        <input type="Radio" name="gender" value="Male"/>Male
                        <input type="Radio" name="gender" value="Female"/> Female
                    </td>
                </tr>
                <tr>
                    <td>My Favourite units *MutilSelect:</td>
                    <td>
                        <select name="favourite" multiple="multiple" size="2">
                            <option value="Poti">Poti</option>
                            <option value="it">IT</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <input type="button" name="submit"/>
                </tr>
            </table>
        </form>
    </body>
</html>