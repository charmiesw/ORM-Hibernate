package hibernateLifeCycle;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransientState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        //Transient
        System.out.println("==========Transient State==========");

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kaveesha");
        customer.setAddress("Galle");

        boolean isContains = session.contains(customer);  //
        if (isContains) {
            System.out.println("This object is not in Transient state");
        } else {
            System.out.println("This object is in Transient state");
        }
    }
}
