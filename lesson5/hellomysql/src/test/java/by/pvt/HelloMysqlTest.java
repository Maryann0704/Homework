package by.pvt;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;
import java.sql.*;

public class HelloMysqlTest extends DBTestCase{

    public HelloMysqlTest() {
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS
                , "com.mysql.jdbc.Driver" );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL
                , "jdbc:mysql://localhost:3306/hello_mysql_junit" );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME
                , "root" );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD
                , "root" );
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(
                HelloMysqlTest.class.getResourceAsStream("system_users.xml"));
    }

    @Test
    public void testConnection() {

        try (
                Connection connection =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hello_mysql_junit"
                                ,"root"
                                ,"root");

                PreparedStatement ps = connection.prepareStatement("select * from system_users");

                ResultSet resultSet = ps.executeQuery();
         ){
            int rowCount = 0;
            int activeUser = 0;
            while (resultSet.next()){
                rowCount++;
                if (resultSet.getBoolean("active"))
                    activeUser++;
            }
            Assert.assertEquals(4, rowCount);
            Assert.assertEquals(2, activeUser);

            Assert.assertNotNull(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
