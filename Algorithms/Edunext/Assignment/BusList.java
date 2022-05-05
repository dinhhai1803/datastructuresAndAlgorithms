package Algorithms.Edunext.Assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BusList {
    // private ArrayList<Bus> iL = new ArrayList<Bus>();
    static LinkedList<Bus> iL2 = new LinkedList<Bus>();

    // public BusList() throws IOException {
    // readFile();
    // }

    public LinkedList<Bus> getiL2() {
        return iL2;
    }

    public void deleteAll() {
        while (iL2.head != null) {
            iL2.head = iL2.head.next;
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        String bCode;
        while (true) {
            System.out.print("Input Bcode: ");
            int count = 0;
            bCode = sc.nextLine();
            Node temp = iL2.head;
            while (temp != null) {

                if (temp.data instanceof Bus) {
                    if (((Bus) temp.data).getBcode().equals(bCode)) {
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
        System.out.print("Input bus name: ");
        String bus_Name = sc.nextLine();

        int numSeat;
        while (true) {
            System.out.print("Input number of seat: ");
            numSeat = sc.nextInt();
            if (numSeat > 0) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println("Invalid input. The number of the seat must be greater than 0. Please input again.");
        }

        int bookedSeat;
        while (true) {
            System.out.print("Input the booked seat: ");
            bookedSeat = sc.nextInt();
            if (bookedSeat >= 0 && bookedSeat <= numSeat) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println(
                    "Invalid input. The number of the booked seat must be greater than 0 and lesser than the number of seat. Please input again.");
        }

        double departTime;
        while (true) {
            System.out.print("Input depart time: ");
            departTime = sc.nextDouble();
            if (departTime >= 0) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println("Invalid input. The depart time must be greater than 0. Please input again.");
        }

        double arrivalTime;
        while (true) {
            System.out.print("Input arrival time: ");
            arrivalTime = sc.nextDouble();
            if (arrivalTime > departTime) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println(
                    "Invalid input. The arrival time must be greater than the depart time. Please input again.");
        }

        Bus s = new Bus(bCode, bus_Name, numSeat, bookedSeat, departTime, arrivalTime);
        iL2.addFirst(s);
        // try {
        // writeFile();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        System.out.println();
        System.out.println("----- To save the file choose option 4 ------");
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
            iL2.addLast(filter(line));
        }

        f_bReader.close();
    }

    public static Bus filter(String info) {
        String newInfo = info.replace('|', ' ');
        String[] b = newInfo.split("\\s+");

        return new Bus(b[0], b[1], Integer.parseInt(b[2]), Integer.parseInt(b[3]), Double.parseDouble(b[4]),
                Double.parseDouble(b[5]));
    }

    // public void writeFile() {
    // try {
    // PrintWriter out = new PrintWriter("Bus.txt");
    // for (Bus i : iL)
    // out.println(i.toString());
    // out.close();
    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // }
    // }

    public void writeFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Enter the name of the file you want to save to (Recommend: the file name should be the same as the file stored Buses): ");
        System.out.print("File name: ");
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

        if (iL2.isEmpty())
            System.out.println("The list is empty");
        else {
            Node temp = iL2.head;
            while (temp != null) {
                f.write(temp.data + "\n");
                temp = temp.next;
            }
            // System.out.println();
        }

        f.close();
    }

    public void display() {
        System.out.println("bcode\t|    Bus_name   |     Booked    |   depart_time |  arrival_time |   travel_time");
        System.out.println("-----------------------------------------------------------------------------------------");
        iL2.traverse();
    }

    Node search(String xCode) {
        Node temp = iL2.head;
        while (temp != null) {
            if (((Bus) temp.data).getBcode().equals(xCode))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void dele(String xCode) {
        Node temp = iL2.head;
        if (((Bus) temp.data).getBcode().equals(xCode))
            iL2.delFirst();

        while (temp != null) {
            if (((Bus) temp.next.data).getBcode().equals(xCode)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    void addBefore() {
        Scanner sc = new Scanner(System.in);
        String bCode;
        while (true) {
            System.out.print("Input Bcode: ");
            int count = 0;
            bCode = sc.nextLine();
            Node temp = iL2.head;
            while (temp != null) {

                if (temp.data instanceof Bus) {
                    if (((Bus) temp.data).getBcode().equals(bCode)) {
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
        System.out.print("Input bus name: ");
        String bus_Name = sc.nextLine();

        int numSeat;
        while (true) {
            System.out.print("Input number of seat: ");
            numSeat = sc.nextInt();
            if (numSeat > 0) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println("Invalid input. The number of the seat must be greater than 0. Please input again.");
        }

        int bookedSeat;
        while (true) {
            System.out.print("Input the booked seat: ");
            bookedSeat = sc.nextInt();
            if (bookedSeat >= 0 && bookedSeat <= numSeat) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println(
                    "Invalid input. The number of the booked seat must be greater than 0 and lesser than the number of seat. Please input again.");
        }

        double departTime;
        while (true) {
            System.out.print("Input depart time: ");
            departTime = sc.nextDouble();
            if (departTime >= 0) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println("Invalid input. The depart time must be greater than 0. Please input again.");
        }

        double arrivalTime;
        while (true) {
            System.out.print("Input arrival time: ");
            arrivalTime = sc.nextDouble();
            if (arrivalTime > departTime) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
            System.out.println(
                    "Invalid input. The arrival time must be greater than the depart time. Please input again.");
        }

        Bus s = new Bus(bCode, bus_Name, numSeat, bookedSeat, departTime, arrivalTime);

        System.out.print("Input k to add the bus before the position k: ");
        int k = sc.nextInt();
        System.out.println("");

        iL2.addAtNth(s, (k - 1));
    }

    void delBefore() {
        Scanner sc = new Scanner(System.in);
        String xCode;
        System.out.print("Input xCode to delete the node before the node having bcode = xCode: ");
        xCode = sc.nextLine();
        System.out.println("");

        Node temp = iL2.head;
        if (((Bus) temp.next.data).getBcode().equals(xCode))
            iL2.delFirst();
        while (temp != null) {
            if (((Bus) temp.next.next.data).getBcode().equals(xCode)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    public void sortByBCode() {
        if (!iL2.isEmpty()) {
            boolean wasChanged;

            do {
                Node current = iL2.head;
                Node previous = null;
                Node next1 = iL2.head.next;
                wasChanged = false;

                while (next1 != null) {
                    if (stringCompare(((Bus) (current.data)).getBcode(), ((Bus) (next1.data)).getBcode()) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next1.next;

                            previous.next = next1;
                            next1.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next1.next;

                            iL2.head = next1;
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