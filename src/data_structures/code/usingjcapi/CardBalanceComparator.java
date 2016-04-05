package data_structures.code.usingjcapi;

import java.util.Comparator;

/**
 * A function object for comparing {@link TrafficCard} objects by their balance.
 *
 * @author Jose Uusitalo
 */
public class CardBalanceComparator implements Comparator<TrafficCard>
{
	@Override
	public int compare(final TrafficCard c1, final TrafficCard c2)
	{
		if (c1.mBalance < c2.mBalance)
			return -1;
		else if (c1.mBalance > c2.mBalance)
			return 1;

		return 0;
	}
}
