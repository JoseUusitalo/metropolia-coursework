package design_patterns.strategy;

import java.util.List;

/**
 * A strategy interface for converting a list to string.
 *
 * @author Jose Uusitalo
 */
public interface ListConverter
{
	/**
	 * Converts the given list to a string.
	 *
	 * @param list list to convert
	 * @return a string of list contents
	 */
	public String listToString(final List<Object> list);
}
