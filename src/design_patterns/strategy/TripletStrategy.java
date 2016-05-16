package design_patterns.strategy;

import java.util.List;

/**
 * A strategy that converts a list to a string with three elements per line using an array.
 *
 * @author Jose Uusitalo
 */
public class TripletStrategy implements ListConverter
{
	@Override
	public String listToString(final List<Object> list)
	{
		final StringBuilder sb = new StringBuilder();
		final Object[] arr = list.toArray();
		final int length = arr.length;

		for (int i = 0; i < length; i += 3)
		{
			sb.append(arr[i]);

			if (i + 1 < length)
			{
				sb.append(", ");
				sb.append(arr[i + 1]);

				if (i + 2 < length)
				{
					sb.append(", ");
					sb.append(arr[i + 2]);
				}
			}

			if (i + 3 < length)
			{
				sb.append(", ");
				sb.append("\n");
			}
		}

		return sb.toString();
	}
}
