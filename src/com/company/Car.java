package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;


public class Car {
    int id;
    String brand;
    String model;
    String fuelType;
    String registrationNumber;
    int registrationYearMonth;
    int kmDriven;

    public Car(int id, String brand, String model, String fuelType, String registrationNumber, int registrationYearMonth, int kmDriven){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.registrationNumber = registrationNumber;
        this.registrationYearMonth = registrationYearMonth;
        this.kmDriven = kmDriven;

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationYearMonth=" + registrationYearMonth +
                ", kmDriven=" + kmDriven +
                '}';
    }

    public static void printToFile(ArrayList<Car> list) throws FileNotFoundException {
        File f = new File("cars.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < list.size(); i++) {
            //if (list.get(i).type.equals("Car") )
            fileWriter.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
            /*System.out.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");*/
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setRegistrationYearMonth(int registrationYearMonth) {
        this.registrationYearMonth = registrationYearMonth;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }
}