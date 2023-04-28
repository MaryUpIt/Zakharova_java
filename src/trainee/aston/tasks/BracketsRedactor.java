/**
 * 4. Дана скобочная последовательность: [((())()(())]]
 *  - Можно ли считать эту последовательность правильной?
 *  - Если ответ на предыдущий вопрос “нет” - то что необходимо в ней изменить, чтоб она стала правильной?
 */

package trainee.aston.tasks;

import java.util.Stack;

public class BracketsRedactor {

    public static boolean isBracketSequence (String input) {
        String regex = "[()\\[\\]{}]+";
        return input.matches(regex);
    }

    public static String getCorrectBracketSequence(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder brackets = new StringBuilder(input);
        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (isOpenBracket(bracket)) {
                stack.push(bracket);
            } else if (!isOpenBracket(bracket)) {
                if (!stack.isEmpty() && isBracketPair(stack.peek(), bracket)) {
                    stack.pop();
                } else {
                    char pairBracket = getPairBracket(bracket);
                    stack.push(pairBracket);
                    brackets.insert(i, pairBracket);
                }
            }
        }
        while (!stack.isEmpty()) {
            char bracket = stack.peek();
            brackets.append(getPairBracket(bracket));
            stack.pop();
        }
        return brackets.toString();
    }

    private static boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private static Character getPairBracket(char bracket) {
        switch (bracket) {
            case '(' : return ')';
            case ')' : return '(';
            case '[' : return ']';
            case ']' : return '[';
            case '{' : return '}';
            case '}' : return '{';
            default : throw new IllegalArgumentException("this is not bracket");
        }
    }

    private static boolean isBracketPair(char openBracket, char closeBracket) {
        return openBracket == '(' && closeBracket == ')'
                || openBracket == '[' && closeBracket == ']'
                || openBracket == '{' && closeBracket == '}';
    }
}
