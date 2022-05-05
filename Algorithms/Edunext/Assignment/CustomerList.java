package Algorithms.Edunext.Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerList {
    static LinkedList<Customer> L = new LinkedList<Customer>();

    public LinkedList<Customer> getL() {
        return L;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Node search(String xCode) {
        Node temp = L.head;
        while (temp != null) {
            if (((Customer) temp.data).getCcode().equals(xCode))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void dele(String xCode) {
        Node temp = L.head;
        if (((Customer) temp.data).getCcode().equals(xCode))
            L.delFirst();

        while (temp != null) {
            if (((Customer) temp.next.data).getCcode().equals(xCode)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void inputCusTomer() {
        Scanner sc = new Scanner(System.in);
        String cCode;
        while (true) {
            System.out.print("Input Ccode: ");
            int count = 0;
            cCode = sc.nextLine();
            Node temp = L.head;
            while (temp != null) {

                if (temp.data instanceof Customer) {
                    if (((Customer) temp.data).getCcode().equals(cCode)) {
                        count++;
                    }
                }
                temp = temp.next;
            }
            if (count != 0) {
                System.out.println("The Bcode need to be unique! Please input again.");
            } else {
                break;
            }

        }
        System.out.print("Input Customer name: ");
        String Cus_Name = sc.nextLine();

        System.out.print("Input the customer number: ");
        String customerNumber = checkNumber();

        Customer c = new Customer(cCode, Cus_Name, customerNumber);
        L.addFirst(c);
        L.traverse();
        try {
            writeFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String checkNumber() {
        String number;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                number = sc.nextLine().trim();
                int numberParsed = Integer.parseInt(number);
                String numberString = numberParsed + "";
                return numberString;
            } catch (NumberFormatException e) {
                System.err.println("Wrong input type, digit only");
                System.out.print("Enter again: ");
            }
        }
    }

    public static void readFile(String url) throws IOException {
        File newFile = new File(url);
        String line;

        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        FileReader f = new FileReader(newFile);
        BufferedReader f_bReader = new BufferedReader(f);

        while ((line = f_bReader.readLine()) != null) {
            L.addLast(filter(line));
        }

        f_bReader.close();
    }

    public static Customer filter(String info) {
        String newInfo = info.replace('|', ' ');
        String[] b = newInfo.split("\\s+");

        return new Customer(b[0], b[1], b[2]);
    }

    public void writeFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file you want to save to: ");
        String url = sc.nextLine();
        url = url + ".txt";
        File newfile = new File(url);
        if (!newfile.exists()) {
            System.err.println("File not exists. Created new File name: " + url);
            newfile.createNewFile();
        }
        FileWriter f = new FileWriter(newfile);

        // for (Bus e : iL)
        // f.write(e.toString() + "\n");

        if (L.isEmpty())
            System.out.println("The list is empty");
        else {
            Node temp = L.head;
            while (temp != null) {
                f.write(temp.data + "\n");
                temp = temp.next;
            }
            // System.out.println();
        }

        f.close();
    }

    public void display() {
        System.out.println("Ccode\t| Customer_name |    Phone    ");
        System.out.println("-------------------------------------");
        L.traverse();
    }

}