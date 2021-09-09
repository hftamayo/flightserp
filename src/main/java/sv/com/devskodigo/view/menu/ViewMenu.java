package sv.com.devskodigo.view.menu;

import sv.com.devskodigo.services.MenuItemAction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewMenu {
    private int userInputOption = 0;
    private int userContinue = 1;
    MenuComponent catalogs;
    MenuComponent flights;
    MenuComponent exit;

    public void createMenu(){
        catalogs = new Menu("Catalogs", "");
        flights = new Menu("Flights Operations", "");
        exit = new Menu("Active Session", "");

        catalogs.add(new MenuItem("Users", "1"));
        catalogs.add(new MenuItem("Country", "2"));
        catalogs.add(new MenuItem("City   ", "3"));
        catalogs.add(new MenuItem("Airline", "4"));
        catalogs.add(new MenuItem("Aircraft", "5"));

        flights.add(new MenuItem("Flights", "6"));
        flights.add(new MenuItem("Reports", "7"));

        exit.add(new MenuItem("Exit   ", "8"));
    }

    public void runMenu(){
        do{
            catalogs.displayMenu();
            System.out.println("--------------------");
            System.out.println();

            flights.displayMenu();
            System.out.println("--------------------");
            System.out.println();

            exit.displayMenu();

            try{
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
            }
            catch(InputMismatchException ime){
                System.out.println("Please type only integer numbers greater than zero");
            }
        }while(userContinue == 1);
    }

}
