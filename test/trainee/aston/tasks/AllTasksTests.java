package trainee.aston.tasks;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        NumberComparisonTest.class,
        NameVyacheslavTest.class,
        MultiplesNumbersTest.class,
        BracketsRedactorTest.class
})

public class AllTasksTests {
}
