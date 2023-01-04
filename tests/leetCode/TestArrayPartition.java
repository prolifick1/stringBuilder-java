package leetCode;

import leetCode.Easy.ArrayPartition;
import org.junit.Assert;
import org.junit.Test;


public class TestArrayPartition {

    @Test
    public void test() {
        ArrayPartition a = new ArrayPartition();
        int actual = a.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2});
        int expected = 9 ;
        Assert.assertEquals(expected, actual);
    }

}
