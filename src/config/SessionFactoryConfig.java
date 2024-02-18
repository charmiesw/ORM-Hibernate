package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sesssionFactoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        //sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).addAnnotatedClass(Customer.class).getMetadataBuilder().build().buildSessionFactory();
        sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (sesssionFactoryConfig == null) ? sesssionFactoryConfig = new SessionFactoryConfig() : sesssionFactoryConfig;
    }

    public Session getSession() {
        //creates and open the session
        //openSession - We create  and open a new session. Then it returns by here
        return  sessionFactory.openSession();

    }
}
