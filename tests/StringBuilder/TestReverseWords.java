package StringBuilder;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestReverseWords {
    @Test
    public void testReverse() {
        String input = "Hello world, how are you?";
        String expectedOutput = "you? are how world, Hello";
        String actualOutput = ReverseWords.reverse(input);
        assertEquals(expectedOutput, actualOutput);
    }
}