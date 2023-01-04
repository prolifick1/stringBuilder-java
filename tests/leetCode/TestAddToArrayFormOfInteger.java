package leetCode;

import leetCode.Easy.AddToArrayFormOfInteger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAddToArrayFormOfInteger {

    @Test
    public void test() {
        AddToArrayFormOfInteger a = new AddToArrayFormOfInteger();
        List<Integer> actual = a.addToArrayForm(new int[]{2, 1, 5}, 806);
        List<Integer> expected = new ArrayList<>() {{
            add(1);
            add(0);
            add(2);
            add(1);
        }};

        Assert.assertEquals(expected, actual);
    }

}
