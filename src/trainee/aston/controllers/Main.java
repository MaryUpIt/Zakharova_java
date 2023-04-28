package trainee.aston.controllers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TasksController controller = new TasksController(System.out, new Scanner(System.in));
        int item = 0;
        do {
            item = controller.getMenuPoint();
            switch (item) {
                case 1 -> {
                    int number = controller.getNumber();
                    controller.showCompareWithSeven(number);
                }
                case 2 -> {
                    String name = controller.getText();
                    controller.showAnswerVyacheslav(name);
                }
                case 3 -> {
                    int[] array = controller.getArray();
                    controller.showFilterArrayWithThree(array);
                }
                case 4 -> {
                    String brackets = controller.getBracketSequence();
                    controller.showCorrectBracketSequence(brackets);
                }
                case 5 -> controller.showGoodBye();
            }
        } while (item != 5);
    }
}
