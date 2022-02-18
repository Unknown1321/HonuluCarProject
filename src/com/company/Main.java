package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Private_Customer.printToFile1;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        ArrayList<Car> carList = new ArrayList<>();
        //carList.sort();
        Luxury car1 = new Luxury(1,"Mercedes", "S-Class", "Benzin", "hy56757",
                2020 - 5, 5000, "3000", "Yes",
                "Yes", "Yes", "Yes");

        Sport car2 = new Sport(2,"Porsche", "Cayenne", "Benzin", "br43575",
                2018 - 6, 17800, "No", "Yes");

        Family car3 = new Family(3, "Volkswagen", "Passat", "Diesel", "re34876",
                2012 - 2, 33600, "Yes", "Yes", "No", "Yes");

        Luxury car4 = new Luxury(4, "BMW", "M3", "Benzin", "kb24008",
                2021 - 7, 2000, "4000", "Yes",
                "Yes", "Yes", "Yes");

        carList.add(0, car1);
        carList.add(1, car2);
        carList.add(2, car3);
        carList.add(3, car4);

        ArrayList<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Private_Customer("Youssef", "Ruten", 2700, "København", 34657809, 39673125, "vikan@gmail.com",
                "43223", "199504");
        Companies customer2 = new Companies("Mardin", "Tingjbjerg", 2700, "København", 76450912, 23658976, "jatak@hotmail.com",
                "TDC", "Molen 2", 39676625, 345123);
        Companies customer3 = new Companies("Mo", "Nørrebro", 2200, "København", 67547823, 35658912, "stacks@outlook.dk",
                "Yousee", "Svinget 3", 64789320, 453594);
        Customer customer4 = new Private_Customer("Anas", "Amager", 2400, "København", 28625902, 45875603, "anas@msn.dk",
                "hf53025", "198503");

        customerList.add(0, customer1);
        customerList.add(1, customer2);
        customerList.add(2, customer3);
        customerList.add(3, customer4);

        ArrayList<rentalContract> rentalContractsList = new ArrayList<>();
        rentalContract rentC1 = new rentalContract(23, "12/10/2021", "21/10/2021", 2000, 23000, "hg54987");
        rentalContract rentC2 = new rentalContract(8, "21/10/2021", "28/10/2021", 2500, 25000, "tf34567");
        rentalContract rentC3 = new rentalContract(24, "28/10/2021", "05/11/2021", 2200, 27000, "ng98435");
        rentalContract rentC4 = new rentalContract(3, "05/11/2021", "12/11/2021", 2400, 29000, "lj23006");

        rentalContractsList.add(0, rentC1);
        rentalContractsList.add(1, rentC2);
        rentalContractsList.add(2, rentC3);
        rentalContractsList.add(3, rentC4);

        printMenu(carList, customerList, rentalContractsList);
        Car.printToFile(carList);
        printToFile1(customerList);
        rentalContract.printToFile2(rentalContractsList);
    }

    public static void printMenu(ArrayList<Car> list, ArrayList<Customer> customerList, ArrayList<rentalContract> rentalContractsList) throws FileNotFoundException {
        System.out.printf("""
                Tast 1 for at se eksisterende under
                Tast 2 for at lave en ny kunde ordre
                Tast 3 for at vise tilgængelige biler
                Tast 4 for at lave en ny bil ordre
                Tast 5 for at se eksisterende udlejninger eller lave nye kontrakter
                Tast 6 for ændre i eksisterende informationer
                Tast 7 for at afslutte
                """);
        System.out.println("Indtast nummer: ");
        int select = Integer.parseInt(input.nextLine());
        if (select == 1) {
            System.out.println("\n\n*** INDLÆSER, VENT VENLIGST ***\n\n");
            for (int i = 0; i < customerList.size(); i++) {
                System.out.println(customerList.get(i) + "\n**************************************************************************************" +
                        "*******************************************************************");
            } printMenu(list, customerList, rentalContractsList);
        } else if (select == 2) {
            System.out.printf("Velkommen !\nHvilken kunde vil du oprette?\nTast 1 for privatkunde\nTast 2 for erhverskunde\n");
            switch (input.nextInt()) {
                case 1:
                    Private_Customer.createPrivateCustomer(input, customerList);
                    System.out.println("Du har lavet en ny privatkunde\n\n*******************\nVender tilbage til menu");
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 2:
                    Companies.createCompanyCustomer(input, customerList);
                    System.out.println("Du har lavet en ny erhvervskunde\n*****************\nVender tilbage til menu");
                    printMenu(list, customerList, rentalContractsList);
                    break;
                default:
                    System.out.print("Du har indtastet forkert, prøv igen\n***********************************\nVender tilbage til menu\n");
                    printMenu(list, customerList, rentalContractsList);
                    break;
            }
        } else if (select == 3) {
            System.out.println("\n\n*** INDLÆSER, VENT VENLIGST ***\n\n");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i) + "\n**************************************************************************************" +
                        "*********************************************");
            } printMenu(list, customerList, rentalContractsList);
        } else if (select == 4) {
            System.out.printf("Velkommen !\nHvilken bil vil du lave?\nTast 1 for luxury\nTast 2 for Sport\nTast 3 for Family\n");
            switch (input.nextInt()) {
                case 1:
                    Luxury.createLuxury(input, list);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 2:
                    Sport.createSport(input, list);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 3:
                    Family.createFamily(input, list);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                default:
                    System.out.print("Du har indtastet forkert, prøv igen\n***********************************\n");
                    printMenu(list, customerList, rentalContractsList);
                    break;
            }
        } else if (select == 5) {
            System.out.println("Tast 1 for at vise eksisterende udlejninger\nTast 2 for at lave en ny kontrakt\n");
            switch (input.nextInt()){
                case 1:
                    for (int i = 0; i < rentalContractsList.size(); i++) {
                        System.out.println(rentalContractsList.get(i) + "\n**************************************************************************************" +
                                "*********************************************");
                        printMenu(list, customerList, rentalContractsList);
                    }
                    break;
                case 2:
                    rentalContract.createRentalContract(input, rentalContractsList);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                default:
                    System.out.print("Du har indtastet forkert, prøv igen\n***********************************\n");
                    printMenu(list, customerList, rentalContractsList);
            }
        } else if (select == 6) {
            System.out.println("Du har valgt at ændre nogle informationer\nTast 1 for Privatkunde\nTast 2 for Erhvervskunde\nTast 3 for Luxury bil\nTast 4 for Sport bil\nTast 5 for Family bil\nTast 6 for at Udlejningskontrakter");
            switch (input.nextInt()) {
                case 1:
                    Private_Customer.changeInfoPrivateCustomer(input, customerList);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 2:
                    Companies.changeInfoCompanyCustomer(input, customerList);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 3:
                    Luxury.changeInfoLuxuryCar(input, list);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 4:
                    Sport.changeInfoSportCar(input, list);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 5:
                    Family.changeInfoFamilyCar(input, list);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                case 6:
                    rentalContract.changeInfoRentalContracts(input, rentalContractsList);
                    printMenu(list, customerList, rentalContractsList);
                    break;
                default:
                    System.out.print("Du har indtastet forkert, prøv igen\n***********************************\n");
                    printMenu(list, customerList, rentalContractsList);
            }
        }if (select == 7) {
            System.out.println("Afslutter Program");
        }
    }
}



