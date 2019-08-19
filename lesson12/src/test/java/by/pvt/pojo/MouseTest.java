package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MouseTest {

    private Mouse mouse;

    @Before
    public void createTestData() {
        mouse = new Mouse(1, "optical", 6.98, new Date(), 6);
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Mouse data = session.get(Mouse.class, 1);
        if (data == null) {
            session.save(this.mouse);
            tx.commit();
            session.close();
        }
    }

    @After
    public void clearData() {
        Session session = HibernateUtil.getInstance().getSession();
        session.createSQLQuery("delete from mouses.mouse");
    }


    @Test
    public void testSaveMouse() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            Mouse mouse2 = new Mouse(11, "mechanic", 1.29, new Date(), 3);
            session.save(mouse2);
            tx.commit();
            List mouses = session.createQuery("from mouse").list();
            assertEquals(2, mouses.size());
        }
        catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMouse() {
        try (Session session = HibernateUtil.getInstance().getSession()) {
            Mouse loadedMouse = session.get(Mouse.class, 1);
            assertEquals("optical", loadedMouse.getType());
        }
    }

    @Test
    public void testUpdateMouse() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            mouse.setPrice(7.99);
            session.update(mouse);
            tx.commit();
            Mouse loadedMouse = session.get(Mouse.class, 1);
            assertEquals(7.99, loadedMouse.getPrice(), 0);
        }
        catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteMouse() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();
            session.delete(mouse);
            tx.commit();
            Mouse loadedMouse = session.get(Mouse.class, 1);
            assertNull(loadedMouse);
        }
        catch (HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}