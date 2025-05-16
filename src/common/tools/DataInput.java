package common.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class DataInput {

    public static int getIntegerNumber(String displayMessage) throws Exception {
        int number = 0;
        System.out.print(displayMessage);
        number = getIntegerNumber();
        return number;
    }

    public static int getIntegerNumber() throws Exception {
        int number = 0;
        String strInput;
        boolean stop = true;
        do {
            strInput = getString();
            if (strInput == "") {
                return 0;
            }
            stop = !DataValidate.checkStringWithFormat(strInput, "\\d{1,10}");
            if (stop) {
                System.out.println("Please re-enter:");
            } else if (number < 0) {
                stop = true;
                System.out.println("Please re-enter:");
            } else {
                number = Integer.parseInt(strInput);
            }
        } while (stop);
        return number;
    }

    public static String getString() {
        String strInput;
        Scanner sc = new Scanner(System.in);
        strInput = sc.nextLine();
        return strInput.trim();
    }

    public static String getString(String displayMessage) {
        String strInput;
        System.out.print(displayMessage);
        strInput = getString();
        return strInput;
    }

    public static String getString(String displayMessage, String pattern) {
        String strInput;
        boolean stop = true;
        do {
            strInput = getString(displayMessage);
            stop = !DataValidate.checkStringWithFormat(strInput, pattern);
            if (stop) {
                System.out.println("Please re-enter:");
            }
        } while (stop);
        return strInput;
    }

    public static String getStringUpdate(String displayMessage, String pattern) {
        String strInput;
        boolean stop = true;
        do {
            strInput = getString(displayMessage).toUpperCase();
            if (strInput == "") {
                return "";
            }
            stop = !DataValidate.checkStringWithFormat(strInput, pattern);
            if (stop) {
                System.out.println("Please re-enter:");
            }
        } while (stop);
        return strInput;
    }

    public static LocalDate getDate(String displayMessage) throws Exception {
        String strInput;
        LocalDate date = null;
        boolean stop = true;
        do {
            strInput = getString(displayMessage);
            stop = !DataValidate.checkStringWithFormat(strInput, "\\d{2}/\\d{2}/\\d{4}");
            if (stop) {
                System.out.println("Please re-enter:");
            } else {
                date = LocalDate.parse(strInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        } while (stop);
        return date;
    }

    public static String getString(String displayMessage, List<String> pattern) {
        String strInput;
        boolean stop = true;
        do {
            strInput = getString(displayMessage).trim().toUpperCase();
            stop = !DataValidate.checkMatchCode(strInput, pattern);
            if (stop) {
                System.out.println("Please re-enter:");
            }
        } while (stop);
        return strInput;
    }

    public static String getStringUpdate(String displayMessage, List<String> pattern) {
        String strInput;
        boolean stop = true;
        do {
            strInput = getString(displayMessage).trim().toUpperCase();
            if (strInput == "") {
                return "";
            }
            stop = !DataValidate.checkMatchCode(strInput, pattern);
            if (stop) {
                System.out.println("Please re-enter:");
            }
        } while (stop);
        return strInput;
    }

    public static LocalDate getDateUpdate(String displayMessage) throws Exception {
        String strInput;
        LocalDate date = null;
        boolean stop = true;
        do {
            strInput = getString(displayMessage);
            if (strInput == "") {
                return null;
            }
            stop = !DataValidate.checkStringWithFormat(strInput, "\\d{2}/\\d{2}/\\d{4}");
            if (stop) {
                System.out.println("Please re-enter:");
            } else {
                date = LocalDate.parse(strInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        } while (stop);
        return date;
    }

}
