package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@SequenceGenerator(name="empl_seq", sequenceName = "empl_seq")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "empl_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String title;
    private Date dateOfBirth;
    private int empNumber;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetails employeeDetails;

    @ManyToOne
    private Department department;

    @ManyToMany
    private List<Project> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addProject(Project project) {
        if (projects == null) projects = new ArrayList<>();
        projects.add(project);
    }
}
