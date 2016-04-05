package data_structures.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * A basic postfix calculator.
 *
 * @author Jose Uusitalo
 */
public class PostfixCalculator
{
	public static final List<String> SUPPORTED_OPERATORS = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));

	/**
	 * Calculates the result of the given postfix expression.
	 *
	 * @param input expression to process
	 * @return the result of the calculation
	 */
	public static double calculate(final String input)
	{
		final String[] elements = input.split(" ");

		if (elements.length == 0)
			return 0.0;

		Stack<Double> numbers = new Stack<Double>();

		double left = 0.0;
		double right = 0.0;
		double result = 0.0;

		for (final String e : elements)
		{
			if (!SUPPORTED_OPERATORS.contains(e))
			{
				// Ignore extra whitespace.
				if (!e.isEmpty())
				{
					try
					{
						System.out.println("Number:   " + e);
						numbers.add(Double.parseDouble(e));
					}
					catch (NumberFormatException e2)
					{
						throw new IllegalArgumentException("Unsupported operator '" + e + "'.");
					}
				}
			}
			else
			{
				// Process the next two numbers.
				right = numbers.pop();
				left = numbers.pop();
				System.out.println("Calculation:         " + left + " " + e + " " + right);

				if (e.equals("+"))
					numbers.push(left + right);
				else if (e.equals("-"))
					numbers.push(left - right);
				else if (e.equals("*"))
					numbers.push(left * right);
				else
					numbers.push(left / right);

				System.out.println("Intermediate result: " + numbers.peek());
				System.out.println("Queue:               " + numbers);
			}
		}
		System.out.println("Result:              " + result + "\n");

		return numbers.pop();
	}
}
