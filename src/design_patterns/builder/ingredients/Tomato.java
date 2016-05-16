package design_patterns.builder.ingredients;

/**
 * A slice of tomato.
 *
 * @author Jose Uusitalo
 */
public class Tomato extends Ingredient
{
	/**
	 * @param name the name of this tomato slice
	 * @param price the price of this tomato slice
	 */
	public Tomato(final String name, final double price)
	{
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Tomato: " + super.toString();
	}
}
