package data_structures.code.usingjcapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author kamaj
 */
public class UsingJCAPI
{
	/**
	 * @param args the command line arguments
	 */
	public static void main(final String[] args)
	{
		ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
		RandomString rString = new RandomString(10);
		float genBalance;
		TrafficCard myCard;
		Random r = new Random();
		int i;
		for (i = 0; i < 10; i++)
		{
			genBalance = ((float) r.nextInt(1000) / 10);
			myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
			cardUsers.add(myCard);
		}

		System.out.println("Unsorted cards.");
		Iterator<TrafficCard> itr = cardUsers.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("\nCards sorted by traveller number.");
		List<TrafficCard> sortedCards = cardUsers;
		Collections.sort(sortedCards);
		itr = sortedCards.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("\nCards sorted by balance.");
		sortedCards = cardUsers;
		Collections.sort(sortedCards, new CardBalanceComparator());
		itr = sortedCards.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("\nCards sorted by owner name.");
		sortedCards = cardUsers;
		Collections.sort(sortedCards, new CardOwnerComparator());
		itr = sortedCards.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("\nCards sorted by traveller number using a lambda expression.");
		Collections.sort(cardUsers, (final TrafficCard c1, final TrafficCard c2) -> (c1.getTravellerNumber() - c2.getTravellerNumber()));
		itr = sortedCards.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("\nCards sorted by traveller number using streams.");
		//@formatter:off
		cardUsers.stream()
				 .sorted((final TrafficCard c1, final TrafficCard c2) -> (c1.getTravellerNumber() - c2.getTravellerNumber()))
				 .forEach(c -> System.out.println(c));
		//@formatter:on
	}
}
