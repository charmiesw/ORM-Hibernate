package hibernateLifeCycle;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachedState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        //Transient state
        System.out.println("==========Transient State==========");

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kaveesha");
        customer.setAddress("Galle");

        boolean isContain = session.contains(customer);
        if (isContain) {
            System.out.println("This is not in Transient state");
        } else {
            System.out.println("This is in Transient state");
        }

        //Persistence state
        System.out.println("\n==========Persistence State==========");

        Transaction transaction = session.beginTransaction();
        int cusId = (int) session.save(customer);
        transaction.commit();
        System.out.println("Customer id : " + cusId);

        boolean isPersistence = session.contains(customer);
        if (isPersistence) {
            System.out.println("This object is in Persistence state");
        } else {
            System.out.println("This object is not in Persistence state");
        }
        session.close();

        //Detach state
        System.out.println("\n==========Detach State==========");

        Session detachSession = SessionFactoryConfig.getInstance().getSession();
        detachSession.detach(customer);

        boolean isPersist = detachSession.contains(customer);
        if (isPersist) {
            System.out.println("This object is in Persistence state");
        } else {
            System.out.println("This object is in Detached state");
        }

        //Persistence state
        System.out.println("\n==========Transient State==========");

        customer.setAddress("Matara");
        detachSession.save(customer);

        boolean isPersistAfterDetach = detachSession.contains(customer);
        if (isPersistAfterDetach) {
            System.out.println("This object is in Persistence state");
        } else {
            System.out.println("This object is not in Persistence state");
        }
        detachSession.close();
    }
}
