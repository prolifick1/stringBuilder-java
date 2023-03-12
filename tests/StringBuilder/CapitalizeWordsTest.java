package StringBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CapitalizeWordsTest {
    @Test
    public void testCapitalize() {
        String input = "hello world";
        String expectedOutput = "Hello World";
        String actualOutput = CapitalizeWords.capitalize(input);
        assertEquals(expectedOutput, actualOutput);
    }
}

