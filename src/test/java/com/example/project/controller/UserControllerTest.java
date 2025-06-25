import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserControllerTest {
    @Test
    void testGetUserById_Positive() {
        UserService mockService = Mockito.mock(UserService.class);
        UserController controller = new UserController(mockService);
        User expected = new User(1, "John");
        Mockito.when(mockService.findUserById(1)).thenReturn(expected);
        User result = controller.getUserById(1);
        assertEquals(expected, result);
    }

    @Test
    void testGetUserById_Negative() {
        UserService mockService = Mockito.mock(UserService.class);
        UserController controller = new UserController(mockService);
        Mockito.when(mockService.findUserById(999)).thenReturn(null);
        User result = controller.getUserById(999);
        assertNull(result);
    }

    @Test
    void testGetUserById_Boundary() {
        UserService mockService = Mockito.mock(UserService.class);
        UserController controller = new UserController(mockService);
        Mockito.when(mockService.findUserById(0)).thenReturn(null);
        User result = controller.getUserById(0);
        assertNull(result);
    }
}
