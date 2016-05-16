package design_patterns.composite;

import design_patterns.composite.components.CPU;
import design_patterns.composite.components.Case;
import design_patterns.composite.components.ComputerComponent;
import design_patterns.composite.components.GPU;
import design_patterns.composite.components.Motherboard;
import design_patterns.composite.components.RAM;
import design_patterns.composite.components.SSD;

/**
 * A computer that contains {@link ComputerComponent} objects.
 *
 * @author Jose Uusitalo
 */
public class Computer
{
	/**
	 * The {@link Case} computer component.
	 */
	private static ComputerComponent computerCase;

	/**
	 * Prints the case price.
	 */
	private static void casePrice()
	{
		System.out.println("Case price: " + computerCase.getPrice());
	}

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		System.out.println("Bare case.");
		computerCase = new Case();
		casePrice();

		System.out.println("\nAdded SSD.");
		computerCase.attach(new SSD());
		casePrice();

		final ComputerComponent motherboard = new Motherboard();
		motherboard.attach(new CPU());
		motherboard.attach(new GPU());
		motherboard.attach(new RAM());

		System.out.println("\nMotherboard price with all components: " + motherboard.getPrice());

		System.out.println("\nAdded motherboard.");
		computerCase.attach(motherboard);
		casePrice();
	}
}
