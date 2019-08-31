package by.pvt.pojo;

import by.pvt.util.HibernateUtil2;
import org.hibernate.Session;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class ManagerTest {

    Session session = HibernateUtil2.getSession();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testDelete() {
        session.beginTransaction();
        Manager managerForDelete = session.get(Manager.class, 1L);
        session.delete(managerForDelete);
        session.getTransaction().commit();
    }

    @Test
    public void testSave() {
        try {
            Manager manager = new Manager(
                    null, df.parse("1988-12-07"), "Greg", "Raider" );
            session.beginTransaction();
            session.save(manager);
            session.getTransaction().commit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadManager() {
        Manager loadedManager = session.load(Manager.class, 2);
        assertEquals("Oleg", loadedManager.getName());
    }

}