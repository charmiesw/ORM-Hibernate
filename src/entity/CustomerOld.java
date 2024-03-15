//package entity;
//
//
//import embedded.MobileNumber;
//import embedded.NameIdentifier;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "customer") // Can define the name of the table
//
//public class CustomerOld {
//    @Id // Defining this column as the primary key column
//    @Column(name = "cus_id") // Can define the column name
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private int id;
//
//    @Column(name = "cus_name")
//    private NameIdentifier name;
//
//    @Column(name = "cus_address")
//    private String address;
//
//    @Column(name = "cus_salary")
//    private double salary;
//
//    @Transient
//    @Column(name = "cus_age")
//    private int age;
//
//    @ElementCollection
//    @CollectionTable(name = "customer_mobile_numbers", joinColumns = @JoinColumn(name = "cus_id"))
//    private List<MobileNumber> mobileNumbers = new ArrayList<>();
//
//    @CreationTimestamp
//    private Timestamp createdDateTime;
//
//    public CustomerOld() {
//    }
//
//    public CustomerOld(int id, NameIdentifier name, String address, double salary, int age, List<MobileNumber> mobileNumbers, Timestamp createdDateTime) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.salary = salary;
//        this.age = age;
//        this.mobileNumbers = mobileNumbers;
//        this.createdDateTime = createdDateTime;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public NameIdentifier getName() {
//        return name;
//    }
//
//    public void setName(NameIdentifier name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public List<MobileNumber> getMobileNumbers() {
//        return mobileNumbers;
//    }
//
//    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
//        this.mobileNumbers = mobileNumbers;
//    }
//
//    public Timestamp getCreatedDateTime() {
//        return createdDateTime;
//    }
//
//    public void setCreatedDateTime(Timestamp createdDateTime) {
//        this.createdDateTime = createdDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", name=" + name +
//                ", address='" + address + '\'' +
//                ", salary=" + salary +
//                ", age=" + age +
//                //", mobileNumbers=" + mobileNumbers +
//                ", createdDateTime=" + createdDateTime +
//                '}';
//    }
//}
