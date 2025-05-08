//scanner lets you read input from the user
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;

        //continously run the program until the user types n 
        while (keepGoing) {
            double num1 = 0, num2 = 0;
            char op;
            double result = 0;
            boolean validInput = true;

            // Read first number
            System.out.print("Enter first number: ");
            if (sc.hasNextDouble()) {
                num1 = sc.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear invalid input
                continue; // restart the loop
            }

            // Read operator
            System.out.print("Enter operator (+, -, *, /): ");
            op = sc.next().charAt(0);

            // Read second number
            System.out.print("Enter second number: ");
            if (sc.hasNextDouble()) {
                num2 = sc.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear invalid input
                continue; // restart the loop
            }

            // Perform calculation
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero.");
                        validInput = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
                    validInput = false;
            }

            // Show result
            if (validInput) {
                System.out.println(num1 + " " + op + " " + num2 + " = " + result);
            }

            // Ask if the user wants to continue
            System.out.print("Do you want to calculate again? (y/n): ");
            char choice = sc.next().toLowerCase().charAt(0);
            if (choice != 'y') {
                keepGoing = false;
            }
        }

        sc.close();
        System.out.println("Calculator exited. Goodbye!");
    }
}


