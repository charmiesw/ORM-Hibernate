package hibernateLifeCycle;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {
    public static void main(String[] args) {
        System.out.println("==========Removed State==========");
        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = session.get(Customer.class, 2);
        boolean isContains = session.contains(customer);
        isContain(isContains);

        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        boolean isRemoved = session.contains(customer);
        isContain(isRemoved);
    }

    private static void isContain(boolean containedOrRemoved) {
        if (containedOrRemoved) {
            System.out.println("Customer is in Persistence state");
        } else {
            System.out.println("Customer is in Removed state");
        }
    }
}
