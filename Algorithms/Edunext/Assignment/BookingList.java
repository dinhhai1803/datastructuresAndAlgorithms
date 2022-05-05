package Algorithms.Edunext.Assignment;

import java.io.IOException;
import java.util.Scanner;

public class BookingList {
    private LinkedList<Booking> L = new LinkedList<Booking>();
    private BusList busL = new BusList();
    private CustomerList cusL = new CustomerList();
    private String bcode, ccode;
    private int k;
    Scanner sc = new Scanner(System.in);

    public void fileLoadBus() {
        String fileName;
        System.out.print(
                "Enter the bus file name (file name only. Recommended(\"Bus\") or the same file name as you to store Bus): ");
        fileName = sc.nextLine();
        fileName = fileName + ".txt";
        try {
            busL.readFile(fileName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Load file successfully");
    }

    public void fileLoadCustomer() {
        System.out.print(
                "Enter the Customer file name (file name only. Recommended(\"Customer\") or the same file name as you to store Customer): ");
        String fileName = sc.next();
        fileName = fileName + ".txt";
        try {
            cusL.readFile(fileName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Load file successfully");
    }

    public void input() {
        boolean check = true;

        fileLoadBus();
        fileLoadCustomer();

        while (check) {
            sc.nextLine();
            System.out.print("Enter bus code: ");
            bcode = sc.nextLine();
            if (busL.search(bcode) == null) {
                System.out.println("Not found Bus Code!");
                continue;
            }
            // ----------------
            check = true;
            System.out.print("Enter customer code: ");
            ccode = sc.nextLine();
            if (cusL.search(ccode) == null) {
                System.out.println("Not found Customer Code!");
                continue;
            }
            // ----------------------------------------------
            check = true;
            Node temp = L.head;
            if (temp == null) {
                check = false;
            } else
                while (temp != null) {
                    if (!((((Booking) temp.data).getCcode().equals(ccode))
                            && ((((Booking) temp.data).getBcode().equals(bcode))))) {
                        check = false;
                        break;
                    }
                }
            if (check) {
                System.out.println("Already Booked!");
                continue;
            }
            // -----------------------------------------
            check = true;
            if (((Bus) ((busL.search(bcode)).data)).getBooked() == ((Bus) ((busL.search(bcode)).data)).getSeat()) {
                System.out.println(" The bus is  exhausted!");
                continue;
            }
            check = false;
            // ------------------------------------
            check = true;
            System.out.print("Enter number of seats to be booked: ");
            k = sc.nextInt();
            sc.nextLine();
            temp = busL.search(bcode);
            if (k <= (((Bus) temp.data).getSeat() - ((Bus) temp.data).getBooked())) {
                Booking b = new Booking(bcode, ccode, k);
                L.addLast(b);
                check = false;
            } else
                System.out.println("Seats booked > available");
        }
    }

    public void display() {
        System.out.println("bcode\t|     Ccode     |  Booked seats ");
        System.out.println("-------------------------------------");
        L.traverse();
    }

    public void sortByBCodenCCode() {
        if (!L.isEmpty()) {
            boolean wasChanged;

            do {
                Node current = L.head;
                Node previous = null;
                Node next1 = L.head.next;
                wasChanged = false;

                while (next1 != null) {
                    if (stringCompare(((Booking) (current.data)).getBcode(), ((Booking) (next1.data)).getBcode()) > 0 ||
                            stringCompare(((Booking) (current.data)).getCcode(),
                                    ((Booking) (next1.data)).getCcode()) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next1.next;

                            previous.next = next1;
                            next1.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next1.next;

                            L.head = next1;
                            next1.next = current;
                            current.next = sig;
                        }

                        previous = next1;
                        next1 = current.next;
                    } else {
                        previous = current;
                        current = next1;
                        next1 = next1.next;
                    }
                }
            } while (wasChanged);
        }

    }

    public static int stringCompare(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }

        else {
            return 0;
        }
    }

}