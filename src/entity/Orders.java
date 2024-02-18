package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_description")
    private String description;

    @jdk.jfr.Timestamp
    @Column(name = "order_datetime")
    private Timestamp dateTime;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Item> items = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Orders() {
    }

    public Orders(int id, String description, Timestamp dateTime) {
        this.id = id;
        this.description = description;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
