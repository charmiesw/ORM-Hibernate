package repository;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    private final Session session;
    public CustomerRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();

        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            System.out.println("Customer : " + customer);
            session.close();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    public Customer getCustomer(int id) throws RuntimeException {
        try {
            Customer customer = session.get(Customer.class, id);
            session.close();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}