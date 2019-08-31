package by.pvt.repository;

import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;
import by.pvt.util.HibernateUtil;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class EmployeeRepositoryTest extends DBTestCase {

    private Session testSession;

    public EmployeeRepositoryTest(String name) {
        super(name);
        testSession = HibernateUtil.getInstance().getTestSession();
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/hello_hibernate_junit?useSSL=false");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
    }

    @Override
    public IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(EmployeeRepositoryTest.class.getResourceAsStream("Employees.xml"));
    }

    @Test
    public void testFindAll() {
        EmployeeRepository employeeRepository = new EmployeeRepository(testSession);
        List<Employee> result = employeeRepository.findAll();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testFindEmployeesNames() {
        EmployeeRepository employeeRepository = new EmployeeRepository(testSession);
        List<String> names = employeeRepository.findEmployeesNames();
        names.forEach(System.out::println);
        final List<String> savedNames = List.of("Ivanov", "Petrov", "Sidorov");
        assertEquals(savedNames, names);
    }

    @Test
    public void testFindEmployeeDetails() {
        EmployeeRepository employeeRepository = new EmployeeRepository(testSession);
        List<EmployeeDetails> details = employeeRepository.findEmployeeDetails();
        assertEquals(2, details.size());
    }

    @Test
    public void testGetEmployeeCount() {
        EmployeeRepository employeeRepository = new EmployeeRepository(testSession);
        Long count = employeeRepository.getEmployeeCount();
        assertEquals(3, (long) count);
    }
}