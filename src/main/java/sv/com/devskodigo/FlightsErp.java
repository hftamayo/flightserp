package sv.com.devskodigo;
/*
name: FlightsErp
purpose:
project's main class, it's the pipeline for submenu and execute a requested class
create an XLSX during first run
author: hftamayo
TODO:
1. clean the screen fuction -> OS independent
2. loop back to main menu
3. if the xlsx exist then open it instead of create it again
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FlightsErp {
    private static Scanner rawData = new Scanner(System.in);

    public static void showSubMenu(int mnu){
        int subMenuOption = 0;
        switch(mnu){
            case 1: //catalogs
                int menu1 = 1;
                do{
                    System.out.println("Catalogs: SubMenu Options");
                    System.out.println("Please type the number related to each submenu");
                    System.out.println("1. Country");
                    System.out.println("2. City");
                    System.out.println("3. Airlines");
                    System.out.println("4. Aircrafts");
                    System.out.println("5. Users");
                    System.out.println("6. Back to Main Menu");

                    subMenuOption = rawData.nextInt();

                    switch(subMenuOption){
                        case 1:
                            Country country = new Country();
                            break;
                        case 2:
                            City city = new City();
                            break;
                        case 3:
                            Airline airline = new Airline();
                            break;
                        case 4:
                            Aircraft aircraft = new Aircraft();
                            break;
                        case 5:
                            User user = new User();
                            break;
                        case 6:
                            menu1 = 0;
                            break;
                    }//end of catalog submenu options
                }while(menu1 == 1);

                break;

            case 2: //flights operations
                int menu2 = 1;
                do{
                    System.out.println("Flights: SubMenu Options");
                    System.out.println("Please type the number related to each submenu");
                    System.out.println("1. Add a Flight");
                    System.out.println("2. Search a Flight");
                    System.out.println("3. Back to Main Menu");

                    subMenuOption = rawData.nextInt();

                    switch(subMenuOption){
                        case 1:
                            Flight f1 = new Flight();
                            f1.addData();
                            break;
                        case 2:
                            Flight f2 = new Flight();
                            f2.searchData();
                            break;
                        case 3:
                            menu2 = 0;
                            break;
                    }//end of catalog submenu options
                }while(menu2 == 1);

                break;

            case 3: //reports
                int menu3 = 1;
                do{
                    System.out.println("Reports: SubMenu Options");
                    System.out.println("Please type the number related to each submenu");
                    System.out.println("1. Add a Report");
                    System.out.println("2. Search Report");
                    System.out.println("4. Back to Main Menu");

                    subMenuOption = rawData.nextInt();

                    switch(subMenuOption){
                        case 1:
                            ReportSummary rpt1 = new ReportSummary();
                            rpt1.addData();
                            break;
                        case 2:
                            ReportSummary rpt2 = new ReportSummary();
                            rpt2.addData();
                            break;
                        case 3:
                            menu3 = 0;
                            break;
                    }//end of catalog submenu options
                }while(menu3 == 1);
                break;
        }//end of mnu switch loop
    }//end of showSubMenu method

    public static void main(String[] args){
        int menuOption = 0;
        int mainMenu = 1;

        System.out.println("Welcome to Flights ERP - Comalapa Airport");
        do{
            System.out.println("Main Menu: please type the number related to one of the above options: ");
            System.out.println("1. Catalogs");
            System.out.println("2. Flight Operations");
            System.out.println("3. Reports");
            System.out.println("4. Exit");
            System.out.println("5. Weather API");
            try{
                menuOption = rawData.nextInt();
                switch(menuOption){
                    case 1:
                    case 2:
                    case 3:
                        showSubMenu(menuOption);
                        break;
                    case 5:
                        WeatherTest wt = new WeatherTest();
                        wt.testapi();
                    default:
                        System.out.println("thank you for use our product. Good bye");
                        mainMenu = 0;
                        break;
                }//end of switch
            }catch(InputMismatchException ime){
                System.out.println("Please type only integer numbers");
                ime.printStackTrace();
            }
        }while(mainMenu == 1);

    }//end of main
}

