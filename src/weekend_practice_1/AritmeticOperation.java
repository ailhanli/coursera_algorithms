package weekend_practice_1;

import java.util.Stack;

public class AritmeticOperation {

	public static void main(String[] args) {

		assert calc("(3*4)+5+(5*2)")==27:"result is different than 70";

	}

	private static int calc(String string) {
		assert isValid(string) : "string has an invalid character";

		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operations = new Stack<>();

		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) == '(') {
				continue;
			} else if (string.charAt(i) == ')') {

				numbers.push(calc(numbers, operations));
				continue;
			}

			if (string.charAt(i) == '+' || string.charAt(i) == '-' || string.charAt(i) == '*'
					|| string.charAt(i) == '/') {
				operations.push(string.charAt(i));
			} else {
				numbers.push(Character.getNumericValue(string.charAt(i)));
			}
		}

		while (!operations.isEmpty()) {
			numbers.push(calc(numbers, operations));
		}

		assert numbers.size() == 1 : "after aritmetic numbers has more than 1 item";

		return numbers.pop();
	}

	private static boolean isValid(String string) {
		Stack<Character> charStack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			Character c = string.charAt(i);
			if (c == '(') {
				charStack.push(c);
			} else if (c == ')') {
				charStack.pop();
			}
		}
		return charStack.size() == 0;
	}

	public static Integer calc(Stack<Integer> numbers, Stack<Character> operations) {
		int result = 0;
		int n1 = numbers.pop();
		int n2 = numbers.pop();
		Character op = operations.pop();
		switch (op) {
		case '+':
			result = n1 + n2;
			break;
		case '-':
			result = n1 - n2;
			break;
		case '*':
			result = n1 * n2;
			break;
		case '/':
			result = n1 / n2;
			break;
		}

		assert result != 0 : "result is 0";
		return result;
	}
}