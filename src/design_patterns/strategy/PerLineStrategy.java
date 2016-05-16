package design_patterns.strategy;

import java.util.Iterator;
import java.util.List;

/**
 * A strategy that converts a list to a string with every element on a new line using an iterator.
 *
 * @author Jose Uusitalo
 */
public class PerLineStrategy implements ListConverter
{
	@Override
	public String listToString(final List<Object> list)
	{
		final Iterator<Object> it = list.iterator();
		final StringBuilder sb = new StringBuilder();

		while (it.hasNext())
		{
			sb.append(it.next().toString());

			if (it.hasNext())
			{
				sb.append(",");
				sb.append("\n");
			}
		}

		return sb.toString();
	}
}
