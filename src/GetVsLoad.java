import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;

public class GetVsLoad {
    public static void main(String[] args) {
        //Save a data
        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = new Customer();
        customer.setName("Kaveesha");
        customer.setAddress("Galle");
        session.save(customer);
        session.close();

        //Get
        Session getSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("========== Get ==========");
        Customer getCustomer = getSession.get(Customer.class, 1);
        System.out.println("Customer id of get : " + getCustomer.getId());
        System.out.println("Customer name of get : " + getCustomer.getName());
        getSession.close();

        //Load
        Session loadSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("========== Load ==========");
        Customer loadCustomer = loadSession.load(Customer.class, 1);
        System.out.println("Customer id of load : " + loadCustomer.getId());
        System.out.println("Customer name of load : " + loadCustomer.getName());
        getSession.close();
    }

}
