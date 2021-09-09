package sv.com.devskodigo.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrudMenu {

    private Scanner getData;

    public CrudMenu(){

    }

    public void showCrudOptions(){
        System.out.println("================");
        System.out.println("Insert a Record -> 1");
        System.out.println("Display Records -> 2");
        System.out.println("Delete a Record -> 3");
        System.out.println("Update a Record -> 4");
        System.out.println("================");
    }

    public int getCrudOption(){
        int crudOpt = 0;
        getData = new Scanner(System.in);
        System.out.println("Please choose one of the above options:");
        try{
            crudOpt = getData.nextInt();

        }catch(InputMismatchException ime){
            System.out.println("Please type only integer numbers greater than zero");
        }
        return crudOpt;
    }

}
