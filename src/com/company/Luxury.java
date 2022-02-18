package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Luxury extends Car {
    String threeThousandCCM;
    String automaticGear;
    String airCondition;
    String cruiseControl;
    String leatherSeats;

    public Luxury(int id, String brand, String model, String fuelType, String registrationNumber, int registrationYearMonth, int kmDriven,
                  String threeThousandCCM, String automaticGear, String airCondition, String cruiseControl, String leatherSeats){
        super(id, brand, model, fuelType, registrationNumber, registrationYearMonth, kmDriven);
        this.threeThousandCCM = threeThousandCCM;
        this.automaticGear = automaticGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
        this.leatherSeats = leatherSeats;

    }

    @Override
    public String toString() {
        return "Luxury{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationYearMonth=" + registrationYearMonth +
                ", kmDriven=" + kmDriven +
                ", threeThousandCCM='" + threeThousandCCM + '\'' +
                ", automaticGear='" + automaticGear + '\'' +
                ", airCondition='" + airCondition + '\'' +
                ", cruiseControl='" + cruiseControl + '\'' +
                ", leatherSeats='" + leatherSeats + '\'' +
                '}';
    }

    public static void createLuxury(Scanner input, ArrayList<Car> list) throws FileNotFoundException {
                System.out.printf("Du har valgt Luxury\n**************************\nIndtast id nummeret\n");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("Hvilket brand er det?");
                String brand = input.nextLine();
                input.nextLine();
                System.out.println("Hvilken model er det?");
                String model = input.nextLine();
                System.out.println("Hvilken fuel type er det?");
                String fuelType = input.nextLine();
                System.out.println("Indtast registreringsnummer");
                String registrationNumber = input.nextLine();
                System.out.println("Indtast registrerings år og måned");
                int registrationYearMonth = input.nextInt();
                System.out.println("Indtast hvor mange kilometer den har kørt");
                int kmDriven = input.nextInt();
                System.out.println("Har bilen over 3000 Ccm?");
                String threeThousandCCM = input.nextLine();
                input.nextLine();
                System.out.println("Har den automat gear?");
                String automaticGear = input.nextLine();
                System.out.println("Har den aircondtion?");
                String airCondition = input.nextLine();
                System.out.println("Har den cruisecontrol?");
                String cruiseControl = input.nextLine();
                System.out.println("Har den lædersæder?");
                String leatherSeats = input.nextLine();
                Car newCar = new Luxury(id, brand, model, fuelType, registrationNumber, registrationYearMonth, kmDriven,
                        threeThousandCCM, automaticGear, airCondition, cruiseControl, leatherSeats);
                list.add(newCar);
        File f = new File("cars.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < list.size(); i++) {
            fileWriter.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
        }
                System.out.println(newCar);
        }
        public static void changeInfoLuxuryCar(Scanner input, ArrayList<Car> list){
        for (int i = 0; i <list.size(); i++){
            System.out.println("Nummer: " + (i+1) + "\t"+ list.get(i));
        }
            System.out.println("Indtast nummeret for den bil hvis information du vil ændre");
        int valg = input.nextInt();
            System.out.println("Indtast den nye fuel type");
            input.nextLine();
            String newFuelType = input.nextLine();
            list.get(valg - 1).setFuelType(newFuelType);
        }

    public void setThreeThousandCCM(String threeThousandCCM) {
        this.threeThousandCCM = threeThousandCCM;
    }

    public void setAutomaticGear(String automaticGear) {
        this.automaticGear = automaticGear;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void setLeatherSeats(String leatherSeats) {
        this.leatherSeats = leatherSeats;
    }
}
