package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Companies extends Customer {
    String companyName;
    String companyAddress;
    int companyPhoneNumber;
    int crn;

    public Companies(String nameOfDriver, String address, int postNumber, String city, int mobilePhone, int phone, String email, String companyName, String companyAddress, int companyPhoneNumber, int crn){
        super(nameOfDriver, address, postNumber, city, mobilePhone, phone, email);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.crn = crn;

    }

    @Override
    public String toString() {
        return "Companies{" +
                "companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhoneNumber=" + companyPhoneNumber +
                ", crn=" + crn +
                ", nameOfDriver='" + nameOfDriver + '\'' +
                ", address='" + address + '\'' +
                ", postNumber=" + postNumber +
                ", city='" + city + '\'' +
                ", mobilePhone=" + mobilePhone +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
    public static void createCompanyCustomer(Scanner input, ArrayList<Customer> customerList) throws FileNotFoundException {
        System.out.printf("Du har valgt erhvervskunde\n**************************\nHvad er kundens navn?\n");
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
        System.out.println("Indtast firmaets navn");
        String companyName = input.nextLine();
        System.out.println("Indtast firmaets adresse");
        String companyAddress = input.nextLine();
        System.out.println("Indtast firmaets nummer");
        int companyPhoneNumber = input.nextInt();
        System.out.println("Indtast Company Registrations Number");
        int crn = input.nextInt();
        Customer newCustomer = new Companies(nameOfDriver, address, postNumber, city, mobilePhone, phone, email, companyName, companyAddress, companyPhoneNumber, crn);
        customerList.add(newCustomer);
        File f = new File("Customer.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < customerList.size(); i++) {
            fileWriter.println(customerList.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
        }
        System.out.println(newCustomer);
    }
    public static void changeInfoCompanyCustomer(Scanner input, ArrayList<Customer> customerList){
        for (int i = 0; i < customerList.size(); i++){
            System.out.println("Nummer: " + (i+1) +"\t"+ customerList.get(i));
        }
        System.out.println("Indtast nummeret for den person hvis information du vil ændre");
        int valg = input.nextInt();
        System.out.println("Indtast den nye addresse");
        input.nextLine();
        String newAddress = input.nextLine();
        customerList.get(valg - 1).setAddress(newAddress);
    }
}
