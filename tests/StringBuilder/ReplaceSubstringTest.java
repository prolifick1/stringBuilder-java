package StringBuilder;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReplaceSubstringTest {
    @Test
    public void testReplace() {
        String input = "Hello world";
        String oldSubstring = "world";
        String newSubstring = "Java";
        String expectedOutput = "Hello Java";
        String actualOutput = ReplaceSubstring.replace(input, oldSubstring, newSubstring);
        assertEquals(expectedOutput, actualOutput);
    }
}
