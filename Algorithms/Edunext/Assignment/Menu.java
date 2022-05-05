package Algorithms.Edunext.Assignment;

import java.util.Scanner;

public abstract class Menu {
    private LinkedList<String> menu;
    private String title;

    public Menu(String[] menu, String title) {
        this.menu = new LinkedList<String>();
        for (int i = 0; i < menu.length; i++)
            this.menu.addLast((i + 1) + ". " + menu[i]);

        this.title = title;

    }

    public void display() {
        System.out.println("\n" + title);
        menu.traverse();
        System.out.println("------------");
        System.out.print("Enter your choice : ");
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public abstract void execute();
}
