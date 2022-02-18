package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Customer {
    String nameOfDriver;
    String address;
    int postNumber;
    String city;
    int mobilePhone;
    int phone;
    String email;

    public Customer(String nameOfDriver, String address, int postNumber, String city, int mobilePhone, int phone, String email){
        this.nameOfDriver = nameOfDriver;
        this.address = address;
        this.postNumber = postNumber;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nameOfDriver='" + nameOfDriver + '\'' +
                ", address='" + address + '\'' +
                ", postNumber=" + postNumber +
                ", city='" + city + '\'' +
                ", mobilePhone=" + mobilePhone +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    public void setNameOfDriver(String nameOfDriver) {
        this.nameOfDriver = nameOfDriver;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMobilePhone(int mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void printToFile1(ArrayList<Customer> list) throws FileNotFoundException {
        File f = new File("customers.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < list.size(); i++) {
            fileWriter.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
            /*System.out.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");*/
        }

    }
}
