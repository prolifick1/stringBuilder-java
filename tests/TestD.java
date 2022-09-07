import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import YandexContest.TaskD;

public class TestD {
    @Test
    public void testReadField() {
        String input =
                "########\n" +
                "#......#\n" +
                "#.#S#.##\n" +
                "##...###\n" +
                "########";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(stream);
        char[][] field = TaskD.readField(scanner, 5, 8);
        Assert.assertEquals(5, field.length);
        Assert.assertEquals(8, field[0].length);
        Assert.assertArrayEquals(field[0], new char[]{'#', '#', '#', '#', '#', '#', '#', '#'});
        Assert.assertArrayEquals(field[1], new char[]{'#', '.', '.', '.', '.', '.', '.', '#'});
        Assert.assertArrayEquals(field[2], new char[]{'#', '.', '#', 'S', '#', '.', '#', '#'});
        Assert.assertArrayEquals(field[3], new char[]{'#', '#', '.', '.', '.', '#', '#', '#'});
        Assert.assertArrayEquals(field[4], new char[]{'#', '#', '#', '#', '#', '#', '#', '#'});
    }

    @Test
    public void test1() {
        String input =
                "5 8\n" +
                        "########\n" +
                        "#......#\n" +
                        "#.#S#.##\n" +
                        "##...###\n" +
                        "########";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        String actual = TaskD.solve(stream);
        String expected =
                "########\n" +
                        "#RRDLLL#\n" +
                        "#U#S#U##\n" +
                        "##RUL###\n" +
                        "########";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        String input =
                "3 3\n" +
                        "###\n" +
                        "#S#\n" +
                        "###";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        String actual = TaskD.solve(stream);
        String expected =
                "###\n" +
                        "#S#\n" +
                        "###";
        Assert.assertEquals(actual, expected);
    }
}