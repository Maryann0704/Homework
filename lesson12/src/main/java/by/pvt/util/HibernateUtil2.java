package by.pvt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class HibernateUtil2 {

    private static Logger log = Logger.getLogger(HibernateUtil2.class.getName());
    private static SessionFactory sessionFactory;

    private HibernateUtil2() {
        try {
            Configuration config = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Throwable e) {
            log.error("Initial SessionFactory creation failed. "+ e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
