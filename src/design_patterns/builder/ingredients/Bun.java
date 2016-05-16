package design_patterns.builder.ingredients;

/**
 * A hamburger bun.
 *
 * @author Jose Uusitalo
 */
public class Bun extends Ingredient
{
	/**
	 * @param name the name of this bun
	 * @param price the price of this bun
	 */
	public Bun(final String name, final double price)
	{
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Bun: " + super.toString();
	}
}
