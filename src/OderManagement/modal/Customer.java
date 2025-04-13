package OderManagement.modal;

public class Customer {
    private int customerId;
    private String customerName;
    private String gender;
    private String phoneNumber;

    public Customer(int customerId, String customerName, String gender, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
