package project.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Created by Stephen on 2014/12/24.
 */
public class DBSession {

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;

    private static DBSession ourInstance = null;

    public static DBSession getInstance() {
        if (ourInstance == null) ourInstance = new DBSession();
        return ourInstance;
    }

    private DBSession() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }
}
