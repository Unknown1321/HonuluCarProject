package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class rentalContract {
    int rentersOrCompanyId;
    String rentalStart;
    String rentalSlut;
    int maxKm;
    int kmStart;
    String registrationPlate;

    public rentalContract(int rentersOrCompanyId, String rentalStart, String rentalSlut, int maxKm, int kmStart, String registrationPlate){
        this.rentersOrCompanyId = rentersOrCompanyId;
        this.rentalStart = rentalStart;
        this.rentalSlut = rentalSlut;
        this.maxKm = maxKm;
        this.kmStart = kmStart;
        this.registrationPlate = registrationPlate;
    }

    @Override
    public String toString() {
        return "rentalContract{" +
                "rentersOrCompanyId=" + rentersOrCompanyId +
                ", rentalStart='" + rentalStart + '\'' +
                ", rentalSlut='" + rentalSlut + '\'' +
                ", maxKm=" + maxKm +
                ", kmStart=" + kmStart +
                ", registrationPlate='" + registrationPlate + '\'' +
                '}';
    }
    public static void printToFile2(ArrayList<rentalContract> rentalContractsList) throws FileNotFoundException {
        File f = new File("rentals.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < rentalContractsList.size(); i++) {
            fileWriter.println(rentalContractsList.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
            /*System.out.println(rentalContractsList.get(i) + "\n**************************************************************************************" +
                    "*********************************************");*/
        }
    }
    public static void createRentalContract(Scanner input, ArrayList<rentalContract> rentalContractsList) throws FileNotFoundException {
        System.out.printf("Du har valgt eksisterende Udlejningskontrakter\n**************************\nIndtast lejeren eller firmaets Id nummer?\n");
        input.nextInt();
        System.out.println("Indtast startsdato for udlejning");
        input.nextLine();
        input.nextLine();
        System.out.println("Indtast slutsdato for udlejning");
        input.nextLine();
        System.out.println("Indtast hvor mange km lejer må maks kører");
        input.nextInt();
        System.out.println("Indtast hvor km bilen har kørt ved udlejningsstart");
        input.nextInt();
        System.out.println("Indtast nummerpladen på bilen");
        input.nextLine();
        input.nextLine();
        rentalContract newRentC1 = new rentalContract(123, "20042021", "27042021", 2000, 50000, "tr45692");
        rentalContractsList.add(newRentC1);
        File f = new File("rentals.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < rentalContractsList.size(); i++) {
            //if (list.get(i).type.equals("Car") )
            fileWriter.println(rentalContractsList.get(i) + "\n**************************************************************************************" +
                    "*********************************************");
            /*System.out.println(list.get(i) + "\n**************************************************************************************" +
                    "*********************************************");*/
        }
        System.out.println(newRentC1);
    }
    public static void changeInfoRentalContracts(Scanner input, ArrayList<rentalContract> rentalContractsList){
        for (int i = 0; i <rentalContractsList.size(); i++){
            System.out.println("Nummer: " + (i+1) + "\t"+ rentalContractsList.get(i));
        }
        System.out.println("Indtast nummeret for den kontrakt hvis information du gerne vil ændre");
        int valg = input.nextInt();
        System.out.println("Indtast den nye startsdato for udlejning");
        input.nextLine();
        String newRentalStart = input.nextLine();
        rentalContractsList.get(valg - 1).setRentalStart(newRentalStart);
    }

    public void setRentersOrCompanyId(int rentersOrCompanyId) {
        this.rentersOrCompanyId = rentersOrCompanyId;
    }

    public void setRentalStart(String rentalStart) {
        this.rentalStart = rentalStart;
    }

    public void setRentalSlut(String rentalSlut) {
        this.rentalSlut = rentalSlut;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public void setKmStart(int kmStart) {
        this.kmStart = kmStart;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }
}