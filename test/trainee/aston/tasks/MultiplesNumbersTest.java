package trainee.aston.tasks;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MultiplesNumbersTest {

    @Test
    public void testWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> Tasks.getMultiplesNumbers(null, 3));
    }

    @Test
    public void testWithEmptyArray() {
        testGetMultiplesNumbers(new int[0], new int[0]);
    }

    @Test
    public void testWithSomeZeroArray() {
        testGetMultiplesNumbers(new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0});
    }

    @Test
    public void testWithSomeArray() {
        testGetMultiplesNumbers(new int[]{-1, -9, 0, 3, 6, 9, 321, 0, 78}, new int[]{-9, 0, 3, 6, 9, 321, 0, 78});
    }

    private void testGetMultiplesNumbers(int[] array, int[] expected) {
        int[] result = Tasks.getMultiplesNumbers(array, 3);
        Assert.assertEquals(result.length, expected.length);
        Assert.assertArrayEquals(result, expected);
    }
}
