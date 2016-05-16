package design_patterns.builder.ingredients;

import java.util.ArrayList;
import java.util.List;

/**
 * A hamburger that consists of {@link Ingredient}s.
 *
 * @author Jose Uusitalo
 */
public class Hamburger extends Ingredient
{
	/**
	 * The {@link Ingredient}s of this hamburger.
	 */
	private List<Ingredient> ingredients;

	/**
	 * @param name the name of this hamburger
	 */
	public Hamburger(final String name)
	{
		this.name = name;
		ingredients = new ArrayList<Ingredient>();
	}

	/**
	 * Adds the specified amount of money to the price of this hamburger.
	 *
	 * @param value money to add
	 */
	public void addPrice(final double value)
	{
		price += value;
	}

	/**
	 * Adds an {@link Ingredient} to this hamburger.
	 *
	 * @param i ingredient to add
	 */
	public void addIngredient(final Ingredient i)
	{
		ingredients.add(i);
		this.price += i.getPrice();
	}

	/**
	 * Prints the receipt for this hamburger.
	 */
	public void printReceipt()
	{
		System.out.println("---Receipt for " + name + "---");

		ingredients.forEach((final Ingredient i) -> System.out.println(i));

		System.out.println("Total: " + String.format("%.2f", getPrice()) + " €");
	}
}
