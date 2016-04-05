package data_structures.code.usingjcapi;

/**
 * @author kamaj
 */
public class TrafficCard implements Comparable<TrafficCard>
{
	int mTravellerNumber;
	String mOwnerName;
	float mBalance;

	public TrafficCard(final int tNumber, final String oName, final float balance)
	{
		mTravellerNumber = tNumber;
		mOwnerName = oName;
		mBalance = balance;
	}

	/**
	 * Gets the traveller number of the owner of this card.
	 *
	 * @return the ID number of the owner
	 */
	public int getTravellerNumber()
	{
		return mTravellerNumber;
	}

	@Override
	public String toString()
	{
		return "owner: " + mOwnerName + " number: " + mTravellerNumber + " balance: " + mBalance;
	}

	@Override
	public int compareTo(final TrafficCard o)
	{
		if (mTravellerNumber < o.mTravellerNumber)
			return -1;
		else if (mTravellerNumber > o.mTravellerNumber)
			return 1;

		return 0;
	}
}
