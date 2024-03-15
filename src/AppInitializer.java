import embedded.MobileNumber;
import embedded.NameIdentifier;
import entity.Customer;
import entity.Orders;
import projection.CustomerProjection;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
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
        List<Customer> customerListJpql = customerRepository2.getAllCustomersJPQL();
        for (Customer customer : customerListJpql) {
            System.out.println("Customer jpql : " + customer);
        }

        CustomerRepository customerRepository3 = new CustomerRepository();
        List<Orders> ordersList = customerRepository3.getOrdersByCustomerId(1);
        for (Orders orders : ordersList) {
            System.out.println("Orders : " + orders);
        }

        CustomerRepository customerRepository4 = new CustomerRepository();
        List<Customer> customerListHql = customerRepository4.getAllCustomerHQL();
        for (Customer customer : customerListHql) {
            System.out.println("Customer hql : " + customer);
        }

        CustomerRepository customerRepository5 = new CustomerRepository();
        List<CustomerProjection> customerProjectionList = customerRepository5.getCustomerProjection();
        for (CustomerProjection customerProjection : customerProjectionList) {
            System.out.println("Customer projection : " + customerProjection);
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
        customer.setId(2);
        customer.setName("Vihara");
        customer.setAddress("Matara");
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