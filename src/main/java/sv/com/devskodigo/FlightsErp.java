package sv.com.devskodigo;
/*
name: FlightsErp
purpose:
project's main class, it's the pipeline for submenu and execute a requested class
create an XLSX during first run
author: hftamayo
 */


import sv.com.devskodigo.view.menu.*;


import java.util.Scanner;

public class FlightsErp {

    public static void main(String[] args){

        int userMenuChosen = 0;

        System.out.println("Welcome to the Airport, please choose one of the bellow options:");

        MenuComponent catalogs = new Menu("Catalogs", "");
        MenuComponent flights = new Menu("Flights Operations", "");
        MenuComponent exit = new Menu("Active Session", "");

        catalogs.add(new MenuItem("Users", "1"));
        catalogs.add(new MenuItem("Country", "2"));
        catalogs.add(new MenuItem("City", "3"));
        catalogs.add(new MenuItem("Airline", "4"));
        catalogs.add(new MenuItem("Aircraft", "5"));

        flights.add(new MenuItem("Flights", "6"));
        flights.add(new MenuItem("Reports", "7"));

        exit.add(new MenuItem("Exit", "8"));

        catalogs.displayMenu();
        System.out.println("--------------------");
        System.out.println();

        flights.displayMenu();
        System.out.println("--------------------");
        System.out.println();

        exit.displayMenu();

        Scanner rawData = new Scanner(System.in);
        System.out.println("Please type your option:");
        userMenuChosen = rawData.nextInt();
        rawData.close();

        MenuItemAction menuaction = new MenuItemAction(userMenuChosen, 8);
        menuaction.executeOption();
    }//end of main
}

