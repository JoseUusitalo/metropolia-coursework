package design_patterns.builder.ingredients;

/**
 * A slice of cheese.
 *
 * @author Jose Uusitalo
 */
public class Cheese extends Ingredient
{
	/**
	 * @param name the name of this cheese
	 * @param price the price of this cheese
	 */
	public Cheese(final String name, final double price)
	{
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Cheese: " + super.toString();
	}
}
