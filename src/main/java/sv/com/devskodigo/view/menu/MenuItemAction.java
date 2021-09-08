package sv.com.devskodigo.view.menu;

public class MenuItemAction {

    private int userOption = 0;
    private int maxValue = 0;

    public MenuItemAction(){

    }

    public void executeAction(int uo, int mv){
        userOption = uo;
        maxValue = mv;
        if(userOption < 1 || userOption > maxValue){
            System.out.println("Invalid option, please try again");
        }
        else{

            switch(userOption){
                case 1:
                    //USER CRUD
                    System.out.println("please instantiate USER");
                    break;
                case 2:
                    //COUNTRY CRUD
                    System.out.println("please instantiate COUNTRY");
                    break;
                case 3:
                    //CITY CRUD
                    System.out.println("please instantiate CITY");
                    break;
                case 4:
                    //AIRLINE CRUD
                    System.out.println("please instantiate AIRLINE");
                    break;
                case 5:
                    //AIRCRAFT CRUD
                    System.out.println("please instantiate AIRCRAFT");
                    break;
                case 6:
                    //FLIGHTS CRUD
                    System.out.println("please instantiate FLIGHTS");
                    break;
                case 7:
                    //REPORTS CRUD
                    System.out.println("please instantiate REPORTS");
                    break;
                case 8:
                    //EXIT
                    System.out.println("Thank you for use our services!");
                    System.exit(0);
                    break;
            }
        }//end of else
    }//end of executeOption
}