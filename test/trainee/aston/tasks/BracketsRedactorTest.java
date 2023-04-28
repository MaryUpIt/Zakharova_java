package trainee.aston.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

class BracketsRedactorTest {

    @Test
    public void testWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> BracketsRedactor.getCorrectBracketSequence(null));
    }

    @Test
    public void testWithText() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> BracketsRedactor.getCorrectBracketSequence("Some text value"));
    }

    @Test
    public void testWithBracketSequence1() {
        testGetCorrectBracketSequence("((())((())(", "((())((())()))");
    }

    @Test
    public void testWithBracketSequence2() {
        testGetCorrectBracketSequence("({}})[[[)((]]])(", "({}{})[[[()(([][][])())]]]");
    }

    @Test
    public void testWithBracketSequence3() {
        testGetCorrectBracketSequence("{[((())]{])", "{[((())[]{[]()})]}");
    }

    @Test
    public void testWithBracketSequence4() {
        testGetCorrectBracketSequence("[]{}{}()", "[]{}{}()");
    }

    private void testGetCorrectBracketSequence(String input, String expected) {
        String result = BracketsRedactor.getCorrectBracketSequence(input);
        Assert.assertEquals(result.length(), expected.length());
        Assert.assertEquals(result, expected);
    }
}