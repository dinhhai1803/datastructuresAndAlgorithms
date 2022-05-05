package Algorithms.Edunext.Assignment;

import java.io.IOException;
import java.util.Scanner;

public class Manager extends Menu {
    private static String[] menu = { "Load data from file (Bus)", "Input & add to the head", "Display data",
            "Save bus list to file",
            "Search by bcode", "Delete by bcode", "Sort by bcode", "Add before position k",
            "Delete the node before the node having bcode = xCode",
            "Load data from file", "Input & add to the end", "Display data", "Save customer list to file",
            "Search by ccode",
            "Delete by ccode", "Input data", "Display data width travel time", "Sort  by bcode + ccode", "Quit" };
    private static Scanner sc = new Scanner(System.in);
    private String url = "Bus.txt";
    protected BusList bl = new BusList();
    protected CustomerList cl = new CustomerList();
    protected BookingList bp = new BookingList();

    public Manager() {
        super(menu, "Bus Booking System");
    }

    @Override
    public void execute() {

        int choice;

        do {
            super.display();
            choice = super.getChoice();

            switch (choice) {
                case 1:
                    fileLoadBus();
                    break;
                case 2:
                    bl.input();
                    break;
                case 3:
                    bl.display();
                    break;
                case 4:
                    try {
                        bl.writeFile();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("Save File completed successfully.");
                    break;
                case 5: {
                    // Search by bcode
                    System.out.print("Enter the Bus code you want to search: ");
                    String xCode = sc.nextLine();
                    if (bl.search(xCode) != null) {
                        System.out.println("Found");
                        System.out.println(
                                "bcode\t|    Bus_name   |     Booked    |   depart_time |  arrival_time |   travel_time");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------");
                        System.out.println(bl.search(xCode).data);
                    } else {
                        System.out.println("Not Found");
                    }
                    break;
                }

                case 6: {
                    // Delete by bcode
                    System.out.print("Enter the bus code you want to delete: ");
                    String xCode = sc.nextLine();
                    bl.dele(xCode);
                    System.out.println("Deleted");
                    break;
                }
                case 7: {
                    // Sort by bcode
                    bl.sortByBCode();
                    System.out.println("Sort completed successfully.");
                    break;
                }
                case 8: {
                    // Add before position k
                    bl.addBefore();
                    break;
                }
                case 9: {
                    // Delete the node before the node having bcode = xCode
                    bl.delBefore();
                    break;
                }
                case 10: {
                    // Load data from file
                    fileLoadCustomer();
                    break;
                }
                case 11: {
                    // Input & add to the end
                    cl.inputCusTomer();
                    break;
                }
                case 12: {
                    // Display data
                    cl.display();
                    break;
                }
                case 13: {
                    // Save customer list to file
                    try {
                        cl.writeFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }
                case 14: {
                    // Search by ccode
                    System.out.print("Enter the Customer code you want to search: ");
                    String xCode = sc.nextLine();
                    if (cl.search(xCode) != null) {
                        System.out.println("Found");
                        System.out.println("Ccode\t| Customer_name |    Phone    ");
                        System.out.println("-------------------------------------");
                        System.out.println(cl.search(xCode).data);
                    } else {
                        System.out.println("Not Found");
                    }

                    break;
                }
                case 15: {
                    // Delete by ccode
                    System.out.print("Enter the Customer code you want to delete: ");
                    String xCode = sc.nextLine();
                    cl.dele(xCode);
                    System.out.println("Deleted");
                    break;
                }
                case 16: {
                    // Input data
                    bp.input();
                    break;
                }
                case 17: {
                    // Display data width travel time
                    bp.display();
                    break;
                }
                case 18: {
                    // Sort by bcode + ccode
                    bp.sortByBCodenCCode();
                    break;
                }

                default:
                    try {
                        // write the list back to the file

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Good Bye !!!");
                    System.exit(0);
            }
        } while (choice > 0 && choice < 19);
    }

    public void fileLoadBus() {
        System.out.print("Enter the file name (recommend \"Bus\"): ");
        String fileName = sc.nextLine();
        fileName = fileName + ".txt";
        try {
            bl.readFile(fileName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Load file successfully");

        if (bl.iL2.isEmpty()) {
            System.out.println("The file is Empty. Continue to write");
        } else {
            System.out.print("The file is existed. Do you want to keep it or not (y/n): ");
            String option = sc.nextLine();
            if (option.equals("n")) {
                bl.deleteAll();
                System.out.println("Deleted All");
            } else {
                System.out.println("Using the file now");
            }
        }
    }

    public void fileLoadCustomer() {
        System.out.print("Enter the file name (Recommend \"Customer\"): ");
        String fileName = sc.nextLine();
        fileName = fileName + ".txt";
        try {
            cl.readFile(fileName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Load file successfully");

        if (cl.L.isEmpty()) {
            System.out.println("The file is Empty. Continue to write");
        }
        // else {
        // System.out.print("The file is existed. Do you want to keep it or not (y/n):
        // ");
        // String option = sc.nextLine();
        // if (option.equals("n")) {
        // cl.deleteAll();
        // System.out.println("Deleted All");
        // } else {
        // System.out.println("Using the file now");
        // }
        // }
    }

}