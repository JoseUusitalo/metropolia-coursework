package design_patterns.factory_method.abstracts;

import design_patterns.factory_method.interfaces.Drink;

/**
 * A creature that can eat and drink.
 *
 * @author Jose Uusitalo
 */
public abstract class FeedingCreature
{
	/**
	 * The {@link Drink} that this creature drinks.
	 */
	Drink drink = null;

	/**
	 * A factory method for creating a drink for this creature.
	 *
	 * @return the created drink
	 */
	public abstract Drink createDrink();

	/**
	 * Makes this creature feed.
	 */
	public void feed()
	{
		eat();
		drink();
	}

	/**
	 * Makes this creature eat.
	 */
	@SuppressWarnings("static-method")
	public void eat()
	{
		System.out.println("Food tastes good.");
	}

	/**
	 * Makes this creature drink its drink.
	 */
	public void drink()
	{
		if (drink == null)
			drink = createDrink();

		System.out.println(drink + " is great after a meal.");
	}
}
