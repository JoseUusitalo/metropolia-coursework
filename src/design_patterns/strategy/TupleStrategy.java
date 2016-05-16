package design_patterns.strategy;

import java.util.List;

/**
 * A strategy that converts a list to a string with two elements per line using the {@link List} interface.
 *
 * @author Jose Uusitalo
 */
public class TupleStrategy implements ListConverter
{
	@Override
	public String listToString(final List<Object> list)
	{
		final StringBuilder sb = new StringBuilder();
		final int size = list.size();

		for (int i = 0; i < size; i += 2)
		{
			sb.append(list.get(i));

			if (i + 1 < size)
			{
				sb.append(", ");
				sb.append(list.get(i + 1));
			}

			if (i + 2 < size)
			{
				sb.append(", ");
				sb.append("\n");
			}
		}

		return sb.toString();
	}
}
