package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Sport extends Car {
    String manualGear;
    String overTwoHundredHp;

    public Sport(int id, String brand, String model, String fuelType, String registrationNumber, int registrationYearMonth, int kmDriven, String manualGear, String overTwoHundredHp) {
        super(id, brand, model, fuelType, registrationNumber, registrationYearMonth, kmDriven);
        this.manualGear = manualGear;
        this.overTwoHundredHp = overTwoHundredHp;

    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationYearMonth=" + registrationYearMonth +
                ", kmDriven=" + kmDriven +
                ", manualGear='" + manualGear + '\'' +
                ", overTwoHundredHp='" + overTwoHundredHp + '\'' +
                '}';
    }

    public static void createSport(Scanner input, ArrayList<Car> list) throws FileNotFoundException {
        System.out.printf("Du har valgt Sport\n**************************\nIndtast id nummeret\n");
        int id1 = input.nextInt();
        input.nextLine();
        System.out.println("Hvilket brand er det?");
        String brand1 = input.nextLine();
        System.out.println("Hvilken model er det?");
        String model1 = input.nextLine();
        System.out.println("Hvilken fuel type er det?");
        String fuelType1 = input.nextLine();
        System.out.println("Indtast registreringsnummer");
        String registrationNumber1 = input.nextLine();
        System.out.println("Indtast registrerings år og måned");
        int registrationYearMonth1 = input.nextInt();
        System.out.println("Indtast hvor mange kilometer den har kørt");
        int kmDriven1 = input.nextInt();
        input.nextLine();
        System.out.println("Har den manuelt gear?");
        String automaticGear1 = input.nextLine();
        System.out.println("Har den over 200 hestekræfter?");
        String overTwoHundredHp = input.nextLine();
        Car newCar1 = new Sport(id1, brand1, model1, fuelType1, registrationNumber1, registrationYearMonth1, kmDriven1, automaticGear1, overTwoHundredHp);
        list.add(newCar1);
        File f = new File("cars.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < list.size(); i++) {
            fileWriter.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
        }
        System.out.println(newCar1);
    }
    public static void changeInfoSportCar(Scanner input, ArrayList<Car> list){
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

    public void setManualGear(String manualGear) {
        this.manualGear = manualGear;
    }

    public void setOverTwoHundredHp(String overTwoHundredHp) {
        this.overTwoHundredHp = overTwoHundredHp;
    }
}

