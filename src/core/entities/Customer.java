package core.entities;

import common.env.Constants;
import common.tools.DataValidate;

public final class Customer {

    private String customerCode;
    private String customerName;
    private String phoneNumber;
    private String email;

    public Customer(String customerCode, String customerName, String phoneNumber, String email) throws Exception {
        setCustomerCode(customerCode);
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setCustomerCode(String customerCode) throws Exception {
        if (!DataValidate.checkStringWithFormat(customerCode, Constants.CUSTOMER_ID_PATTERN)) {
            throw new Exception("Customer code invalid.");
        }
        this.customerCode = customerCode;
    }

    public void setCustomerName(String customerName) throws Exception {
        if (!DataValidate.checkStringWithFormat(customerName, Constants.NAME_PATTERN)) {
            throw new Exception("Customer name invalid.");
        }
        this.customerName = customerName;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (!DataValidate.checkStringWithFormat(phoneNumber, Constants.PHONE_PATTERN)) {

            throw new Exception("Phone number invalid.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) throws Exception {
        if (!DataValidate.checkStringWithFormat(email, Constants.EMAIL_PATTERN)) {
            throw new Exception("Email invalid.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return customerCode + ", " + customerName + ", " + email + ", " + phoneNumber;
    }
}
