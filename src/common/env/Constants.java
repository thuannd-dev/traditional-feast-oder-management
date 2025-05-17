package common.env;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String NAME_PATTERN = "[A-Za-z|\\s]{2,25}";
    public static final String PHONE_PATTERN = "^(0?)(3[2-9]|5[689]|7[06789]|8[0-689]|9[0-46-9])[0-9]{7}$";
    public static final String CUSTOMER_ID_PATTERN = "^(C|G|K|c|g|k)\\d{4}$";
    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String CUSTOMER_FILE = "./src/files/CustomerData.txt";
    public static final String FEAST_MENU_FILE = "./src/files/FeastMenu.csv";
    public static final String ORDER_FILE = "./src/files/OrderData.txt";
    public static final List<String> FEAST_CODE_LIST = new ArrayList<>();
}
