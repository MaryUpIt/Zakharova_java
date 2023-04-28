/**
 * 1. Составить алгоритм: если введенное число больше 7, то вывести “Привет”
 * 2. Составить алгоритм: если введенное имя совпадает с Вячеслав,
 *    то вывести “Привет,Вячеслав”, если нет, то вывести "Нет такого имени"
 * 3. Составить алгоритм: на входе есть числовой массив,
 *    необходимо вывести элементы массива кратные 3
 */

package trainee.aston.tasks;

import java.util.Arrays;
import java.util.Stack;

public class Tasks {

    public static String compareWithNumber(int input, int number) {
        return input > number ? "Привет" : null;
    }

    public static String compareWithName(String input, String name) {
        return name.equalsIgnoreCase(input) ? "Привет, " + name : "Нет такого имени";
    }

    public static int[] getMultiplesNumbers(int[] array, int number) {
        return Arrays.stream(array).filter(element -> element % number == 0).toArray();
    }
}
