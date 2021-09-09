package sv.com.devskodigo.services;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuItemActionTest {
    @Test
    public void whenAddCalledValueCaptured() {
        MenuItemAction mockMenuItemAction = mock(MenuItemAction.class);
        ArgumentCaptor<Integer> valueCapture = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(mockMenuItemAction).executeAction(any(Integer.class), valueCapture.capture());
        mockMenuItemAction.executeAction(0, 8);

        assertEquals(1, valueCapture.getValue());

        /*answering a call to void

        MenuItemAction mockMenuItemAction = mock(menuItemAction.class);
        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(1, arg0);
            aseertEquals(8, arg1);
            return null;
        }).when(mockMenuItemAction).executeAction(any(Integer.class), any(Integer.class));
        mockMenuItemAction.executeAction(1, 8);
         */
    }

}
