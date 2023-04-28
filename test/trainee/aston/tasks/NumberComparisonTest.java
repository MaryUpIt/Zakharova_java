package trainee.aston.tasks;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

class NumberComparisonTest {

    @Test
    public void testWithMinValue() {
        testCompareWithSeven(Integer.MIN_VALUE, null);
    }

    @Test
    public void testWithMaxValue() {
        testCompareWithSeven(Integer.MAX_VALUE, "Привет");
    }

    @Test
    public void testWithNegativeNumbers() {
        testCompareWithSeven(-10, null);
        testCompareWithSeven(-1310, null);
    }

    @Test
    public void testWithSeven() {
        testCompareWithSeven(7, null);
    }

    @Test
    public void testWithZero() {
        testCompareWithSeven(0, null);
    }

    @Test
    public void testWithPositiveNumbers() {
        testCompareWithSeven(2, null);
        testCompareWithSeven(8, "Привет");
        testCompareWithSeven(287, "Привет");
        testCompareWithSeven(1000, "Привет");
    }

    private void testCompareWithSeven(int number, String answer) {
        String result = Tasks.compareWithNumber(number, 7);
        Assert.assertEquals(answer, result);

    }

}