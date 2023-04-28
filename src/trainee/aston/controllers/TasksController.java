package trainee.aston.controllers;

import trainee.aston.tasks.BracketsRedactor;
import trainee.aston.tasks.Tasks;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public record TasksController(PrintStream stream, Scanner scanner) {

    public static final String MENU = """
                        
            1. Вывести "Привет", если число больше 7.
            2. Вывести "Привет, Вячеслав", если имя Вячеслав.
            3. Вывести элементы массива кратные 3м.
            4. Правильная скобочная последовательность.
            5. Выйти из проверок.
            """;

    public static final String NEED_NUMBER = "Введите число: ";
    private static final String NEED_NAME = "Введите имя: ";
    private static final String NEED_ARRAY = "Введите множество чисел через пробел: ";
    public static final String TRY_AGAIN = "Ввод неверный, попробуйте снова\n";
    private static final String EMPTY_ARRAY = "Ваш массив путой или в нем нет чисел, кратных 3м\n";
    private static final String NEED_BRACKETS = "Введите скобочную последовательность: ";
    private static final String CORRECT_BRACKETS = "Правильная скобочная последовательность: %s\n";
    private static final String INPUT_BRACKETS = "Скобочная последовательность %s - %s\n";
    private static final String GOODBYE = "До свидаия!";

    public int getNumber() {
        stream.print(NEED_NUMBER);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            stream.print(TRY_AGAIN);
            return getNumber();
        }
    }

    public int getMenuPoint() {
        stream.print(MENU);
        return getNumber();
    }

    public void showCompareWithSeven(int number) {

        stream.println(Tasks.compareWithNumber(number, 7));
    }

    public String getText() {
        stream.print(NEED_NAME);
        return scanner.nextLine().trim();
    }

    public void showAnswerVyacheslav(String name) {
        stream.println(Tasks.compareWithName(name, "Вячеслав"));
    }

    public int[] getArray() {
        stream.print(NEED_ARRAY);
        String[] line = scanner.nextLine().trim().split(" ");
        try {
            return line.length == 0 || line == null ? new int[0] : IntStream.range(0, line.length).map(i -> Integer.parseInt(line[i])).toArray();
        } catch (NumberFormatException e) {
            stream.print(TRY_AGAIN);
            return getArray();
        }
    }

    public void showFilterArrayWithThree(int[] array) {
        int[] filterArray = Tasks.getMultiplesNumbers(array, 3);
        if (filterArray.length == 0) {
            stream.print(EMPTY_ARRAY);
        } else {
            stream.print("[ ");
            for (int i = 0; i < filterArray.length; i++) {
                stream.print(i == filterArray.length - 1 ? filterArray[i] + " ]\n" : filterArray[i] + ", ");
            }
        }
    }

    public String getBracketSequence() {
        stream.print(NEED_BRACKETS);
        String brackets = scanner.nextLine();
        if (!BracketsRedactor.isBracketSequence(brackets)) {
            stream.print(TRY_AGAIN);
            return getBracketSequence();
        }
        return brackets;
    }

    public void showCorrectBracketSequence(String input) {
        String result = BracketsRedactor.getCorrectBracketSequence(input);
        if (input.equals(result)) {
            stream.printf(INPUT_BRACKETS, input, "правильная");
        } else {
            stream.printf(INPUT_BRACKETS, input, "не правильная");
            stream.printf(CORRECT_BRACKETS, result);
        }
    }

    public void showGoodBye() {
        stream.print(GOODBYE);
    }
}