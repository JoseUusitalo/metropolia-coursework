package design_patterns.builder.ingredients;

/**
 * A hamburger patty.
 *
 * @author Jose Uusitalo
 */
public class Patty extends Ingredient
{
	/**
	 * @param name the name of this hamburger patty
	 * @param price the price of this hamburger patty
	 */
	public Patty(final String name, final double price)
	{
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Patty: " + super.toString();
	}
}
