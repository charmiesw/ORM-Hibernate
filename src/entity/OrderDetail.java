package entity;

import embedded.OrderDetailPK;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;

    @Column(name = "order_quantity")
    private int quantity;

    @Column(name = "order_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(OrderDetailPK orderDetailPK, int quantity, double price, Orders orders, Item item) {
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.price = price;
        this.orders = orders;
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orders=" + orders +
                ", item=" + item +
                '}';
    }
}
