package by.pvt.pojo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Manager implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Date dateOfBirth;

    @Column
    private String name;

    @Column
    private String surname;

    public Manager(Integer id, Date dateOfBirth, String name, String surname) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
}
