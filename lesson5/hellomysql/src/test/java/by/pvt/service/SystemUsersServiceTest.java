package by.pvt.service;

import by.pvt.dto.SystemUsers;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;


public class SystemUsersServiceTest extends DBTestCase {

    public SystemUsersServiceTest() {
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS
                , "com.mysql.jdbc.Driver");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL
                , "jdbc:mysql://localhost:3306/hello_mysql_junit");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME
                , "root");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD
                , "root");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(
                SystemUsersServiceTest.class.getResourceAsStream("system_users.xml"));
    }

    private SystemUsers systemUser = new SystemUsers();

    @Test
    public void testGet() {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/hello_mysql_junit"
                             , "root"
                             , "root");
             PreparedStatement ps = connection.
                     prepareStatement("select * from system_users");
             ResultSet rs = ps.executeQuery()
        ) {
            new SystemUsersService().getSystemUsers();

            int users = 0;
            while (rs.next()) {
                users++;
            }
            assertEquals(4, users);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/hello_mysql_junit"
                             , "root"
                             , "root")
        ) {
            systemUser.setId(5);
            systemUser.setUsername("User57");
            systemUser.setActive(false);

            new SystemUsersService().insertSystemUser(systemUser);

            PreparedStatement ps = connection.
                    prepareStatement("select * from system_users where id=5");
            ResultSet rs = ps.executeQuery();

            assertEquals(5, rs.getInt("id"));
            assertEquals("User57", rs.getString("username"));
            assertFalse(rs.getBoolean("active"));

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/hello_mysql_junit"
                             , "root"
                             , "root")
        ) {
            systemUser.setUsername("Denis");
            systemUser.setActive(true);

            new SystemUsersService().updateSystemUser(systemUser);

            PreparedStatement ps = connection.
                    prepareStatement("select * from system_users where id=5");
            ResultSet rs = ps.executeQuery();

            assertEquals("Denis", rs.getString("username"));
            assertTrue(rs.getBoolean("active"));

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDelete() {

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/hello_mysql_junit"
                             , "root"
                             , "root");
             PreparedStatement ps = connection.
                     prepareStatement("select * from system_users");
             ResultSet rs = ps.executeQuery()

        ) {
            new SystemUsersService().deleteSystemUser(5);

            AtomicInteger numberUsers = new AtomicInteger();
            while (rs.next()){
                numberUsers.getAndIncrement();
            }

            assertEquals(4, numberUsers.get());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}