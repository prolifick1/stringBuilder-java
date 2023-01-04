package leetCode;

import leetCode.HashTables.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class TestTwoSum {
    @Test
    public void test() {
        TwoSum ts = new TwoSum();
        int[] actual = ts.searchingSummands(6, new int[]{3,3,1});
        int[] expected = new int[]{0,1};
        Assert.assertArrayEquals(expected, actual);
    }
}
