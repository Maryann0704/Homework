package by.pvt.service;

import by.pvt.dto.SystemUsers;
import by.pvt.dto.SystemUsersExample;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import java.util.List;


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

    private SystemUsersService service = new SystemUsersService(true);
    private SystemUsers systemUser = new SystemUsers();

    @Test
    public void testInsert() {
        systemUser.setId(5);
        systemUser.setUsername("User57");
        systemUser.setActive(false);

        service.insertSystemUser(systemUser);
        List<SystemUsers> systemUsers = service.getSystemUsers(null);

        assertEquals(5, systemUsers.size());

    }

    @Test
    public void testGet() {
        List<SystemUsers> systemUsers = service.getSystemUsers(null);

        assertEquals(4, systemUsers.size());

        SystemUsersExample example = new SystemUsersExample();

        example.createCriteria().andActiveEqualTo(true);
        List<SystemUsers> systemUsers2 = service.getSystemUsers(example);

        assertEquals(2, systemUsers2.size());
    }

    @Test
    public void testUpdate() {
        systemUser.setId(17);
        systemUser.setUsername("Denis");
        systemUser.setActive(true);

        service.insertSystemUser(systemUser);
        systemUser.setUsername("Alex");

        int result = service.updateSystemUser(systemUser);

        assertEquals(1, result);

    }

    @Test
    public void testDelete() {
        service.deleteSystemUser(16);
        List<SystemUsers> systemUsers = service.getSystemUsers(null);

        assertEquals(3, systemUsers.size());
    }

    @Test
    public void testAddAll() {
//        service.addAll(users);
//        List<SystemUsers> allUsers = service.getSystemUsers();
//
//        assertEquals(7, allUsers.size());
    }
}