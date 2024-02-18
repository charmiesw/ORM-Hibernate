import embedded.MobileNumber;
import embedded.NameIdentifier;
import entity.Customer;
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
//        System.out.println("\n======GET======");
//        customerRepository = new CustomerRepository();
//        Customer customer = customerRepository.getCustomer(getCustomer().getId());
//        System.out.println("Customer : " + customer);

        CustomerRepository customerRepository1 = new CustomerRepository();
        customerRepository1.getAllCustomersNative();

        CustomerRepository customerRepository2 = new CustomerRepository();
        List<Customer> customerList = customerRepository2.getAllCustomersJPQL();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        // 03. UPDATE
//        System.out.println("\n======UPDATE======");
//        customerRepository = new CustomerRepository();
//        customer.setAddress("Matara");
//        customerRepository.updateCustomer(customer);
//        System.out.println("Customer : " + customer);
//
//        // 04. DELETE
//        System.out.println("\n======DELETE======");
//        customerRepository = new CustomerRepository();
//        customerRepository.deleteCustomer(customer);
//        System.out.println("Customer : " + customer);
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Charmie");
        customer.setAddress("Galle");
//        customer.setMobileNumbers(getMobileNumbers());
//        customer.setSalary(25000.00);
//        customer.setAge(21);
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