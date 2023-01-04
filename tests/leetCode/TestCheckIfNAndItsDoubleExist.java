package leetCode;

import leetCode.Easy.CheckIfNAndItsDoubleExist;
import org.junit.Assert;
import org.junit.Test;

public class TestCheckIfNAndItsDoubleExist {


    @Test
    public void test() {
        CheckIfNAndItsDoubleExist c = new CheckIfNAndItsDoubleExist();
        boolean actual = c.checkIfExist(new int[]{7, 1, 14, 11});
        boolean expected =true;
        Assert.assertEquals(expected, actual);
    }
}
