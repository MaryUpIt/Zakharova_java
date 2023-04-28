package trainee.aston.tasks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class NameVyacheslavTest {

    @Test
    public void testWithNull() {
        testCompareWithName(null, "Нет такого имени");
    }

    @Test
    public void testWithSomeName() {
        testCompareWithName("SomeName", "Нет такого имени");
    }

    @Test
    public void testWithEmptyString() {
        testCompareWithName("", "Нет такого имени");
    }

    @Test
    public void testWithVyacheslav() {
        testCompareWithName("Вячеслав", "Привет, Вячеслав");
    }


    private void testCompareWithName(String name, String expected) {
        String result = Tasks.compareWithName(name, "Вячеслав");
        Assert.assertEquals(result.length(), expected.length());
        Assert.assertEquals(result, expected);
    }


}
