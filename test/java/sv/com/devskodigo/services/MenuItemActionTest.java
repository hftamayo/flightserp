package sv.com.devskodigo.services;

import org.junit.Test;
import org.junit.Assert;

public class MenuItemActionTest {
    @Test
    public void testRunMenu() throws Exception{
        MenuItemAction menuItemAction = new MenuItemAction();
        Assert.assertEquals(1, menuItemAction.executeAction(1, 8));
    }
}
