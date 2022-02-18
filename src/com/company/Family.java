package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Family extends Car {
    String manualGear;
    String airCondition;
    String someWithCruiseControl;
    String sevenSeatsOrMore;

    public Family(int id, String brand, String model, String fuelType, String registrationNumber, int registrationYearMonth, int kmDriven, String manualGear, String airCondition, String someWithCruiseControl, String sevenSeatsOrMore){
        super(id, brand, model, fuelType, registrationNumber, registrationYearMonth, kmDriven);
        this.manualGear = manualGear;
        this.airCondition = airCondition;
        this.someWithCruiseControl = someWithCruiseControl;
        this.sevenSeatsOrMore = sevenSeatsOrMore;

    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationYearMonth=" + registrationYearMonth +
                ", kmDriven=" + kmDriven +
                ", manualGear='" + manualGear + '\'' +
                ", airCondition='" + airCondition + '\'' +
                ", someWithCruiseControl='" + someWithCruiseControl + '\'' +
                ", sevenSeatsOrMore='" + sevenSeatsOrMore + '\'' +
                '}';
    }

    public static void createFamily(Scanner input, ArrayList<Car> list) throws FileNotFoundException {
        System.out.printf("Du har valgt Family\n**************************\nIndtast id nummeret\n");
        int id2 = input.nextInt();
        input.nextLine();
        System.out.println("Hvilket brand er det?");
        String brand2 = input.nextLine();
        input.nextLine();
        System.out.println("Hvilken model er det?");
        String model2 = input.nextLine();
        System.out.println("Hvilken fuel type er det?");
        String fuelType2 = input.nextLine();
        System.out.println("Indtast registreringsnummer");
        String registrationNumber2 = input.nextLine();
        System.out.println("Indtast registrerings år og måned");
        int registrationYearMonth2 = input.nextInt();
        System.out.println("Indtast hvor mange kilometer den har kørt");
        int kmDriven2 = input.nextInt();
        input.nextLine();
        System.out.println("Har den manuelt gear?");
        String automaticGear2 = input.nextLine();
        System.out.println("Har den aircondtion?");
        String airCondition2 = input.nextLine();
        System.out.println("Har den cruisecontrol?");
        String cruiseControl2 = input.nextLine();
        System.out.println("Har den over 7 sæder");
        String leatherSeats2 = input.nextLine();
        Car newCar2 = new Family(id2, brand2, model2, fuelType2, registrationNumber2, registrationYearMonth2, kmDriven2, automaticGear2, airCondition2, cruiseControl2, leatherSeats2);
        list.add(newCar2);
        File f = new File("cars.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < list.size(); i++) {
            fileWriter.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
        }
        System.out.println(newCar2);
    }
    public static void changeInfoFamilyCar(Scanner input, ArrayList<Car> list){
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

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public void setSomeWithCruiseControl(String someWithCruiseControl) {
        this.someWithCruiseControl = someWithCruiseControl;
    }

    public void setSevenSeatsOrMore(String sevenSeatsOrMore) {
        this.sevenSeatsOrMore = sevenSeatsOrMore;
    }
}
