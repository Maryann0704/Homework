package by.pvt.repository;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;

abstract class BaseDbUnitTest extends DBTestCase {

    BaseDbUnitTest(String name) {
        super(name);
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS
                , "com.mysql.jdbc.Driver");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL
                , "jdbc:mysql://localhost:3306/hello_hibernate");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME
                , "root");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD
                , "root");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return null;
    }

}
