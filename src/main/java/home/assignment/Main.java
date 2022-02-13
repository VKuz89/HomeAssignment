package home.assignment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("Press 1: Read from logfile");
            System.out.println("Press 2: Write logfile to database");
            System.out.println("Press 3: Exit");

            System.out.println("Make your choice");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ReadLog readLog = new ReadLog();
                    readLog.readFromLog("C:/Users/VLAD/Desktop/Posti Messaging/log.log");
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please make a valid choice. ");
            }
        }
    }
}
