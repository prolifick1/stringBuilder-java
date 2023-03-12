package hackerrank;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestBubbleSort {
    @Test
    public void first_last_elements_correct() {

        // redirect standard out to a byte array stream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int[] arr = {5, 3, 1, 4, 2};
        BubbleSort.bubbleSort(arr);

        // check if first and last elements are correct
        assertEquals(1, arr[0]);
        assertEquals(5, arr[arr.length - 1]);

        // check if standard out prints the correct output
        String expectedOutput = "Number of swaps: 7\nFirst element: 1\nLast element: 5\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}