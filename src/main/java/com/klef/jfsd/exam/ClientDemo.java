package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Scanner scanner = new Scanner(System.in);

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Device");
            System.out.println("2. Add SmartPhone");
            System.out.println("3. Add Tablet");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Device d = new Device();
                    System.out.println("Enter Device ID: ");
                    d.setId(scanner.nextInt());
                    scanner.nextLine(); 
                    System.out.println("Enter Device Brand: ");
                    d.setBrand(scanner.nextLine());
                    System.out.println("Enter Device Model: ");
                    d.setModel(scanner.nextLine());
                    System.out.println("Enter Device Price: ");
                    d.setPrice(scanner.nextDouble());
                    session.save(d);
                    System.out.println("Device added successfully!");
                    break;

                case 2:
                    SmartPhone sp = new SmartPhone();
                    System.out.println("Enter SmartPhone ID: ");
                    sp.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter SmartPhone Brand: ");
                    sp.setBrand(scanner.nextLine());
                    System.out.println("Enter SmartPhone Model: ");
                    sp.setModel(scanner.nextLine());
                    System.out.println("Enter SmartPhone Price: ");
                    sp.setPrice(scanner.nextDouble());
                    scanner.nextLine(); 
                    System.out.println("Enter Camera Specification: ");
                    sp.setCamera(scanner.nextLine());
                    System.out.println("Enter Operating System: ");
                    sp.setOs(scanner.nextLine());
                    session.save(sp);
                    System.out.println("SmartPhone added successfully!");
                    break;

                case 3:
                    Tablet tb = new Tablet();
                    System.out.println("Enter Tablet ID: ");
                    tb.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter Tablet Brand: ");
                    tb.setBrand(scanner.nextLine());
                    System.out.println("Enter Tablet Model: ");
                    tb.setModel(scanner.nextLine());
                    System.out.println("Enter Tablet Price: ");
                    tb.setPrice(scanner.nextDouble());
                    scanner.nextLine(); 
                    System.out.println("Enter Battery Life: ");
                    tb.setBattery(scanner.nextLine());
                    System.out.println("Enter Screen Size: ");
                    tb.setScreensize(scanner.nextDouble());
                    session.save(tb);
                    System.out.println("Tablet added successfully!");
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        tx.commit();
        session.close();
        sf.close();
        scanner.close();
        System.out.println("Program terminated.");
    }
}
