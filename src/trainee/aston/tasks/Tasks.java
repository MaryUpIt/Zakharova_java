package trainee.aston.tasks;

import java.util.Arrays;

public class Tasks {

    public static String compareWithNumber(int input, int number) {
        return input > number ? "Привет" : null;
    }

    public static String compareWithName(String input, String name) {
        if (input == null || name == null) {
            return "Нет такого имени";
        }
        return name.equalsIgnoreCase(input) ? "Привет, " + name : "Нет такого имени";
    }

    public static int[] getMultiplesNumbers(int[] array, int number) {
        return Arrays.stream(array).filter(element -> element % number == 0).toArray();
    }
}
