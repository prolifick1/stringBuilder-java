package leetCode;

import leetCode.Easy.CreateTargetArrayInGivenOrder;
import org.junit.Assert;
import org.junit.Test;

public class TestCreateTargetArrayInGivenOrder {

    @Test
    public void test() {
        CreateTargetArrayInGivenOrder c = new CreateTargetArrayInGivenOrder();
        int[] actual = c.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
        int[] expected = new int[]{0, 4, 1, 3, 2};
        Assert.assertEquals(actual, expected);
    }
}
