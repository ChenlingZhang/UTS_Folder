package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is a util to connect JDBC
 */
public class JDBC_Connection {
    private String databaseName = "FinalAssignment";
    private String usr = "root";
    private String pwd = "Zxy199569";
    private String URL = "jdbc:mysql://localhost:3306/"+databaseName+"?useSSL=false&serverTimezone=UTC";
    private String DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Get JDBC connection
     * @return
     * @throws Exception
     */
    public Connection connect () throws Exception{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL,usr,pwd);
        return connection;
    }

    /**
     * This method used to close JDBC connection
     * @param connection
     * @throws Exception
     */
    public void closeConnection(Connection connection) throws  Exception{
        if (connection !=null){
            connection.close();
        }
    }

}
