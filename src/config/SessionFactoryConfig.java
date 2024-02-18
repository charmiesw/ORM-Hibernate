package config;

import embedded.OrderDetailPK;
import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        //sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).addAnnotatedClass(Customer.class).getMetadataBuilder().build().buildSessionFactory();
        sessionFactory = new Configuration().configure().
                addAnnotatedClass(Customer.class).
                addAnnotatedClass(Item.class).
                addAnnotatedClass(Orders.class).
                addAnnotatedClass(OrderDetail.class).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (sessionFactoryConfig == null) ? sessionFactoryConfig = new SessionFactoryConfig() : sessionFactoryConfig;
    }

    public Session getSession() {
        //creates and open the session
        //openSession - We create  and open a new session. Then it returns by here
        return  sessionFactory.openSession();

    }
}
