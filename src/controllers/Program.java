package controllers;

import common.env.Constants;
import core.interfaces.ICustomer;
import core.interfaces.IOrder;
import data.CustomerDAO;
import data.FeastDAO;
import data.OrderDAO;
import view.Menu;

public class Program {

    public static void main(String[] args) {
        try {
            do {
                ICustomer studentService = new CustomerDAO(Constants.CUSTOMER_FILE);
                FeastDAO feastService = new FeastDAO(Constants.FEAST_MENU_FILE);
                IOrder orderService = new OrderDAO(Constants.ORDER_FILE);
                Menu.manageStudent(studentService, feastService, orderService);
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
