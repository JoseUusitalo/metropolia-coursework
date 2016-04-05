package data_structures.code.usingjcapi;

import java.util.Comparator;

/**
 * A function object for comparing {@link TrafficCard} objects by the name of their owner.
 *
 * @author Jose Uusitalo
 */
public class CardOwnerComparator implements Comparator<TrafficCard>
{
	@Override
	public int compare(final TrafficCard c1, final TrafficCard c2)
	{
		return c1.mOwnerName.compareToIgnoreCase(c2.mOwnerName);
	}
}
