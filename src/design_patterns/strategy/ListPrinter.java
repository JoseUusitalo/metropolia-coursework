package design_patterns.strategy;

import java.util.List;

/**
 * A basic class for printing the contents of a list.
 *
 * @author Jose Uusitalo
 */
public class ListPrinter
{
	/**
	 * The list to print.
	 */
	private List<Object> list;

	/**
	 * The converter to use when converting the list data to a string.
	 */
	private ListConverter converter;

	/**
	 * @param list the list to be used
	 */
	public ListPrinter(final List<Object> list)
	{
		this.list = list;
	}

	/**
	 * Sets the strategy for printing the contents of the list.
	 *
	 * @param strategy converter strategy to use
	 */
	public void setStrategy(final ListConverter strategy)
	{
		this.converter = strategy;
	}

	/**
	 * Prints the list in this list printer.
	 */
	public void printList()
	{
		if (converter == null)
			System.out.println(list);
		else
			System.out.println(converter.listToString(list));
	}
}
