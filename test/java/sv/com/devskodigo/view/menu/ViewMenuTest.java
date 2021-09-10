package sv.com.devskodigo.view.menu;

import org.junit.Test;
import sv.com.devskodigo.view.ViewMenu;

public class ViewMenuTest {
    @Test
    public void testRunMenu() throws Exception{
        ViewMenu viewMenu = new ViewMenu();
        //como puedo estar seguro que no es un falso positivo
        viewMenu.createMenu();
        //viewMenu.runMenu();
    }
}
