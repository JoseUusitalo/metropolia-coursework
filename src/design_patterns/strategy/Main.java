package design_patterns.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * A strategy pattern example.
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final List<Object> ints = new ArrayList<Object>();

		for (int i = 1; i <= 8; i++)
			ints.add(i);

		final ListPrinter printer = new ListPrinter(ints);

		System.out.println(" - No Strategy -");
		printer.printList();

		System.out.println(" - Per Line Strategy -");
		printer.setStrategy(new PerLineStrategy());
		printer.printList();

		System.out.println(" - Tuple Strategy -");
		printer.setStrategy(new TupleStrategy());
		printer.printList();

		System.out.println(" - Triplet Strategy -");
		printer.setStrategy(new TripletStrategy());
		printer.printList();
	}
}
