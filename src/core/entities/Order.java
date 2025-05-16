package core.entities;

import java.time.LocalDate;

public class Order {

    String orderID;
    String customerCode;
    String feastCode;
    int price;
    int numberTable;
    LocalDate date;
    int totalPrice;

    public Order(String orderID, String customerCode, String feastCode, int price, int numberTable, LocalDate date) {
        this.orderID = orderID;
        this.customerCode = customerCode;
        this.feastCode = feastCode;
        this.price = price;
        this.numberTable = numberTable;
        this.date = date;
        this.totalPrice = price * numberTable;
    }

    public String getOrderID() {
        return orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getFeastCode() {
        return feastCode;
    }

    public int getNumberTable() {
        return numberTable;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setFeastCode(String feastCode) {
        this.feastCode = feastCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        String date = this.date.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return orderID + ", " + customerCode + ", " + feastCode + ", " + price + ", " + numberTable + ", " + date + ", " + totalPrice;
    }
}
