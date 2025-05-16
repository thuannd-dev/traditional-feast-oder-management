package data;

import core.entities.Customer;
import core.interfaces.ICustomer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDAO implements ICustomer {

    private final List<Customer> customersList = new ArrayList<>();
    private final FileManager fileManager;

    public CustomerDAO(String fileName) throws Exception {
        this.fileManager = new FileManager(fileName);
        loadData();
    }

    public void loadData() throws Exception {
        String customerCode, customerName, email, phoneNumber;
        try {
            customersList.clear();
            List<String> customersData = fileManager.readDataFromFile();
            for (String e : customersData) {
                List<String> cus = Arrays.asList(e.split(","));
                customerCode = cus.get(0).trim();
                customerName = cus.get(1).trim();
                email = cus.get(2).trim();
                phoneNumber = cus.get(3).trim();
                Customer cusO = new Customer(customerCode, customerName, phoneNumber, email);
                customersList.add(cusO);
                if (customersList.isEmpty()) {
                    throw new Exception("Customer list is empty.");
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Customer> getCustomers() throws Exception {
        customersList.sort((e1, e2) -> e1.getCustomerName().compareToIgnoreCase(e2.getCustomerName()));
        return customersList;
    }

    @Override
    public Customer getCustomerById(String id) throws Exception {
        if (customersList.isEmpty()) {
            getCustomers();
        }
        Customer customer = customersList.stream().filter(e -> e.getCustomerCode().equals(id)).findFirst().orElse(null);
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        customersList.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        Customer cus = getCustomerById(customer.getCustomerCode());
        if (cus != null) {
            cus.setCustomerName(cus.getCustomerName());
            cus.setEmail(cus.getEmail());
            cus.setPhoneNumber(cus.getPhoneNumber());
        }
    }

    @Override
    public void removeCustomer(Customer customer) throws Exception {
        if (customersList.isEmpty()) {
            getCustomers();
        }
        Customer cus = getCustomerById(customer.getCustomerCode());
        if (cus != null) {
            customersList.remove(cus);
        }
    }

    @Override
    public void saveCustomersListToFile() throws Exception {
        List<String> stringObject = customersList.stream().map(String::valueOf).collect(Collectors.toList());
        String data = String.join("\n", stringObject);
        fileManager.saveDataToFile(data);
    }

}
