package by.pvt.loader;

import by.pvt.pojo.Manager;
import by.pvt.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ManagerLoader {
    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Manager manager = new Manager(null, df.parse("1984-05-17"), "Oleg", "Ivanov");
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(manager);
        em.getTransaction().commit();
        HibernateUtil.close();
    }
}
