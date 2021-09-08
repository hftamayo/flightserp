package sv.com.devskodigo;
/*
name: FlightsErp
purpose:
-project's main class, instantiate menu and menutitems
-the class MenuItemAction is in charge to handle user input
author: hftamayo
 */


import sv.com.devskodigo.view.menu.*;


import java.util.Scanner;

public class FlightsErp {

    public static void main(String[] args){

        int userInputOption = 0;
        int userContinue = 1;

        System.out.println("Welcome to the Airport, please choose one of the bellow options:");

        MenuComponent catalogs = new Menu("Catalogs", "");
        MenuComponent flights = new Menu("Flights Operations", "");
        MenuComponent exit = new Menu("Active Session", "");

        catalogs.add(new MenuItem("Users", "1"));
        catalogs.add(new MenuItem("Country", "2"));
        catalogs.add(new MenuItem("City   ", "3"));
        catalogs.add(new MenuItem("Airline", "4"));
        catalogs.add(new MenuItem("Aircraft", "5"));

        flights.add(new MenuItem("Flights", "6"));
        flights.add(new MenuItem("Reports", "7"));

        exit.add(new MenuItem("Exit   ", "8"));

        do{
            catalogs.displayMenu();
            System.out.println("--------------------");
            System.out.println();

            flights.displayMenu();
            System.out.println("--------------------");
            System.out.println();

            exit.displayMenu();

            Scanner rawData = new Scanner(System.in);
            System.out.println("Please type your option:");
            userInputOption = rawData.nextInt();

            MenuItemAction menuItemAction = new MenuItemAction();
            menuItemAction.executeAction(userInputOption, 8);

            System.out.println("Would you like to continue? 1->Yes, 0->No: ");
            userContinue = rawData.nextInt();
            if (userContinue == 0){
                rawData.close();
            }
        }while(userContinue == 1);



    }//end of main
}
