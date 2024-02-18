import config.SessionFactoryConfig;
import embedded.MobileNumber;
import embedded.NameIdentifier;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class Appinitializer {
    public static void main(String[] args) {
        // 01. SAVE
        System.out.println("\n======SAVE======");
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());

        // 02. GET
        System.out.println("\n======GET======");
        Session getSession = SessionFactoryConfig.getInstance().getSession();
        Customer existingCustomer = getSession.get(Customer.class, 001);
        System.out.println("Existing customer : " + existingCustomer);
        getSession.close();

        // 03. UPDATE
        /*System.out.println("\n======UPDATE======");
        Session updateSession = SessionFactoryConfig.getInstance().getSession();
        Transaction updateTransaction = updateSession.beginTransaction();
        Customer updateCustomer = updateSession.get(Customer.class, 001);
        updateCustomer.setAddress("Matara");
        updateSession.update(updateCustomer);
        updateTransaction.commit();
        System.out.println("Updated customer : " + updateCustomer);
        updateSession.close();

        // 04. DELETE
        System.out.println("\n======DELETE======");
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
        Transaction deleteTransaction = deleteSession.beginTransaction();
        Customer deleteCustomer = deleteSession.get(Customer.class, 001);
        deleteSession.delete(deleteCustomer);
        deleteTransaction.commit();
        System.out.println("Deleted Customer : " + deleteCustomer);
        deleteSession.close();*/
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(001);
        customer.setName(getNameIdentifier());
        customer.setAddress("Galle");
        customer.setMobileNumbers(getMobileNumbers());
        customer.setSalary(25000.00);
        customer.setAge(21);
        return customer;
    }

    private static List<MobileNumber> getMobileNumbers() {
        MobileNumber homeNumber = new MobileNumber();
        homeNumber.setType("HOME");
        homeNumber.setMobileNumber("0768863355");

        MobileNumber workNumber = new MobileNumber();
        workNumber.setType("WORK");
        workNumber.setMobileNumber("0702782407");

        List<MobileNumber> mobileNumbers = new ArrayList<>();
        mobileNumbers.add(homeNumber);
        mobileNumbers.add(workNumber);

        return mobileNumbers;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Kaveesha");
        nameIdentifier.setLastName("Dinujaya");
        return nameIdentifier;
    }
}