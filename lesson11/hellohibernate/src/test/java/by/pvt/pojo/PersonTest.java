package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testSavePerson() {
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {
            tx = session.beginTransaction();
            Person person = createTestData();
            session.save(person);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            List<Person> personList = session.createQuery("from person").list();
            assertEquals(1, personList.size());
            Person p2 = personList.get(0);
            assertEquals(person, p2);
            tx.commit();
            session.close();

            session = HibernateUtil.getInstance().getSession();
            tx = session.beginTransaction();
            Person loadedPerson = session.get(Person.class, 1);
            assertEquals(person, loadedPerson);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    private static Person createTestData() {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("FirstName");
        person.setLastName("LastName");
        person.setDateOfBirth(new Date());
        person.setGender('f');
        return person;
    }

}