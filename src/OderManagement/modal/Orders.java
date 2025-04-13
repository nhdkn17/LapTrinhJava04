package OderManagement.modal;

public class Orders {
    private Customer customer;
    private OrderItems orderItems;

    public Orders(Customer customer, OrderItems orderItems) {
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Orders() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }
}
