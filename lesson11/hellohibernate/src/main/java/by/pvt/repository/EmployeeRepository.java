package by.pvt.repository;

import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;
import org.hibernate.Session;

import java.util.List;

public class EmployeeRepository {

    private Session session;

    public EmployeeRepository(Session session) {
        this.session = session;
    }

    public List<Employee> findAll() {
        return session.createQuery("from Employee", Employee.class).list();
    }

    public List<String> findEmployeesNames() {
        return session.createQuery("select E.name from Employee E"
                , String.class)
                .list();
    }

    public List<EmployeeDetails> findEmployeeDetails() {
        return session.createQuery("select E.employeeDetails from Employee E"
                , EmployeeDetails.class)
                .list();
    }

    public Long getEmployeeCount() {
        return session.createQuery("select count(id) from Employee", Long.class)
                .getSingleResult();
    }
}