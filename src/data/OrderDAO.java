package data;

import core.entities.Order;
import core.interfaces.IOrder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDAO implements IOrder {

    private final List<Order> ordersList = new ArrayList<>();
    private final FileManager fileManager;

    public OrderDAO(String fileName) throws Exception {
        this.fileManager = new FileManager(fileName);
        loadData();
    }

    public void loadData() throws Exception {
        String orderID, customerCode, feastCode;
        LocalDate date;
        int price, numberTable;
        try {
            ordersList.clear();
            List<String> orderData = fileManager.readDataFromFile();
            for (String e : orderData) {
                List<String> orderS = Arrays.asList(e.split(","));
                orderID = orderS.get(0).trim();
                customerCode = orderS.get(1).trim();
                feastCode = orderS.get(2).trim();
                price = Integer.parseInt(orderS.get(3).trim());
                numberTable = Integer.parseInt(orderS.get(4).trim());
                date = LocalDate.parse(orderS.get(5).trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Order order = new Order(orderID, customerCode, feastCode, price, numberTable, date);
                ordersList.add(order);
                if (ordersList.isEmpty()) {
                    throw new Exception("Order list is empty.");
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Order> getOrders() throws Exception {
        return ordersList;
    }

    public void addOrder(Order order) throws Exception {
        ordersList.add(order);
    }

    public Order getOrderById(String id) throws Exception {
        if (ordersList.isEmpty()) {
            getOrders();
        }
        Order order = ordersList.stream().filter(e -> e.getOrderID().equals(id)).findFirst().orElse(null);
        return order;
    }

    public void updateOrder(Order order) throws Exception {
        Order orderO = getOrderById(order.getOrderID());
        if (orderO == null) {
            throw new Exception("Order not found");
        }
        orderO.setCustomerCode(order.getCustomerCode());
        orderO.setFeastCode(order.getFeastCode());
        orderO.setPrice(order.getPrice());
        orderO.setNumberTable(order.getNumberTable());
        orderO.setDate(order.getDate());
        orderO.setTotalPrice(order.getTotalPrice());
    }

    public boolean checkDuplication(String customerCode, String feastCode, LocalDate date) throws Exception {
        if (ordersList.isEmpty()) {
            getOrders();
        }
        Order order = ordersList.stream().filter(e -> e.getCustomerCode().equalsIgnoreCase(customerCode) && e.getFeastCode().equalsIgnoreCase(feastCode) && e.getDate().equals(date)).findFirst().orElse(null);
        return order != null;
    }

    public void saveOrdersListToFile() throws Exception {
        List<String> stringObject = ordersList.stream().map(String::valueOf).toList();
        String data = String.join("\n", stringObject);
        fileManager.saveDataToFile(data);
    }
}
