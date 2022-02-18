package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Private_Customer extends Customer {
    String driverLicenseNumber;
    String driverSinceDate;

    public Private_Customer(String nameOfDriver, String address, int postNumber, String city, int mobilePhone, int phone, String email, String driverLicenseNumber, String driverSinceDate){
        super(nameOfDriver, address, postNumber, city, mobilePhone, phone, email);
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverSinceDate = driverSinceDate;
    }

    @Override
    public String toString() {
        return "Private_Customer{" +
                "nameOfDriver='" + nameOfDriver + '\'' +
                ", address='" + address + '\'' +
                ", postNumber=" + postNumber +
                ", city='" + city + '\'' +
                ", mobilePhone=" + mobilePhone +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                ", driverSinceDate='" + driverSinceDate + '\'' +
                '}';
    }
    public static void createPrivateCustomer(Scanner input, ArrayList<Customer> customerList) throws FileNotFoundException {
        System.out.printf("Du har valgt privatkunde\n\n**************************\nHvad er kundens navn?\n");
        String nameOfDriver = input.nextLine();
        input.nextLine();
        System.out.println("Hvad er kundens adresse?");
        String address = input.nextLine();
        System.out.println("Indtast postnummer");
        int postNumber = input.nextInt();
        System.out.println("Indtast by");
        String city = input.nextLine();
        input.nextLine();
        System.out.println("Indtast mobilnummer");
        int mobilePhone = input.nextInt();
        System.out.println("Indtast hjemmenummer");
        int phone = input.nextInt();
        System.out.println("Indtast email");
        String email = input.nextLine();
        input.nextLine();
        System.out.println("Indtast kørekort nummer");
        String driverLicenseNumber = input.nextLine();
        System.out.println("Indtast hvornår kunden fik udstedt kørekortet");
        String driverSinceDate = input.nextLine();
        Customer newCustomer = new Private_Customer(nameOfDriver, address, postNumber, city, mobilePhone, phone, email, driverLicenseNumber, driverSinceDate);
        customerList.add(newCustomer);
        File f = new File("Customer.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < customerList.size(); i++) {
            fileWriter.println(customerList.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
        }
        System.out.println(newCustomer);
    }
    public static void changeInfoPrivateCustomer(Scanner input, ArrayList<Customer> customerList){
        for (int i = 0; i < customerList.size(); i++){
            System.out.println("Nummer: " + (i+1) +"\t"+ customerList.get(i));
        }
        System.out.println("\nIndtast nummeret for den person hvis information du vil ændre");
        int valg = input.nextInt();
        System.out.println("Indtast den nye addresse");
        input.nextLine();
        String newAddress = input.nextLine();
        customerList.get(valg - 1).setAddress(newAddress);
        System.out.printf("Adressen er ændret\nVil du også ændre postnummeret?");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("nej")){
            System.out.println(customerList);
        } else {
            for (int i = 0; i < customerList.size(); i++){
                System.out.println("Nummer: " + (i+1) +"\t"+ customerList.get(i));
            }
            System.out.println("Indtast nummeret for den person hvis information du vil ændre");
            int valg1 = input.nextInt();
            System.out.println("Indtast det nye postnummer");
            input.nextLine();
            int newPostNumber = input.nextInt();
            customerList.get(valg1 - 1).setPostNumber(newPostNumber);
            System.out.println(customerList);
        }
    }
}
