import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    int add(String expression) {
        if (expression == null || expression.isEmpty())
            return 0;

       String[] tokens = expression.split("[,:]");
        int result = 0;
        for (String token:tokens)
             result += Integer.parseInt(token);

        return result;
    }

    int calculate(String expression) {
        if (expression == null || expression.isEmpty())
            return 0;

        String[] tokens = expression.split(" ");
        Stack<Integer> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (String token:tokens) {
            if (token.isBlank())
                continue;
            if (token.matches("[+\\-*/]")) {
                operators.push(token.strip());
            } else {
                int operand = Integer.parseInt(token.strip());
                if (operands.isEmpty())
                    operands.push(operand);
                else {
                    int operand1 = operand;
                    int operand2 = operands.pop();
                    String operator = operators.pop();
                    switch (operator) {
                        case "+":
                            operands.push(add(operand2,operand1));
                            break;
                        case "-":
                            operands.push(subtract(operand2,operand1));
                            break;
                        case "*":
                            operands.push(multiply(operand2, operand1));
                            break;
                        case "/":
                            operands.push(divide(operand2, operand1));
                            break;
                    }
                }
            }
        }

        return operands.pop();

    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(cal.calculate(s));
    }

}