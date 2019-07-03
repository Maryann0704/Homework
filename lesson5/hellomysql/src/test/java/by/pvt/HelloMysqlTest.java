package by.pvt;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.*;

public class HelloMysqlTest {

    @Test
    public void testConnection() {

        try {
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hello_mysql"
                            ,"root"
                            ,"root");

            PreparedStatement ps = connection.prepareStatement("select * from system_users");

            ResultSet resultSet = ps.executeQuery();

            assertNotNull(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
