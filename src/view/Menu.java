package view;

import java.util.Arrays;
import java.util.List;

import business.CustomerManagement;
import core.interfaces.ICustomer;
import core.interfaces.IOrder;
import data.FeastDAO;
import data.OrderDAO;
import common.tools.DataInput;

public class Menu {
  public static void print(String str) {
        List<String> menuList = Arrays.asList(str.split("\\|"));
        menuList.forEach(menuItem -> {
            if (menuItem.equalsIgnoreCase("Select")) {
                System.out.print(menuItem);
            } else {
                System.out.println(menuItem);
        }});
  }
  public static int getUserChoice() {
      int number = 0;
      try {
          number = DataInput.getIntegerNumber();
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
      return number;
  }

  public static void manageStudent(ICustomer service, FeastDAO feastService, IOrder orderService) {
    CustomerManagement customerMenu = new CustomerManagement(service, feastService, orderService);
    customerMenu.processMenu();
  }
}
