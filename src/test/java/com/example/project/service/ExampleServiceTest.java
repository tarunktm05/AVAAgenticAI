import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExampleServiceTest {
    @Test
    void testAddNumbers_Positive() {
        ExampleService service = new ExampleService();
        int result = service.addNumbers(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testAddNumbers_Negative() {
        ExampleService service = new ExampleService();
        int result = service.addNumbers(-2, -3);
        assertEquals(-5, result);
    }

    @Test
    void testAddNumbers_Boundary() {
        ExampleService service = new ExampleService();
        int result = service.addNumbers(Integer.MAX_VALUE, 1);
        assertTrue(result < 0); // overflow
    }
}
