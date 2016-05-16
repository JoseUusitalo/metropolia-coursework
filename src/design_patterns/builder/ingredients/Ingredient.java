package design_patterns.builder.ingredients;

/**
 * An abstract ingredient used to build a meal.
 *
 * @author Jose Uusitalo
 */
public class Ingredient
{
	/**
	 * The name of this ingredient.
	 */
	protected String name;

	/**
	 * The price of this ingredient.
	 */
	protected double price;

	/**
	 * @return the name and price of this ingredient
	 */
	@Override
	public String toString()
	{
		return name + " (" + String.format("%.2f", price) + " €)";
	}

	/**
	 * Gets the name of this ingredient.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the price of this ingredient in Euros.
	 *
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}
}
