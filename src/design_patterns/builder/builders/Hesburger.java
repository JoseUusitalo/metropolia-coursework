package design_patterns.builder.builders;

import design_patterns.builder.ingredients.Bun;
import design_patterns.builder.ingredients.Cheese;
import design_patterns.builder.ingredients.Hamburger;
import design_patterns.builder.ingredients.Lettuce;
import design_patterns.builder.ingredients.Patty;
import design_patterns.builder.ingredients.Pickles;
import design_patterns.builder.ingredients.Tomato;

/**
 * An implementation of the {@link HamburgerBuilder} that creates Hesburger hamburgers.
 *
 * @author Jose Uusitalo
 */
public class Hesburger implements HamburgerBuilder
{
	/**
	 * The hamburger being built.
	 */
	private Hamburger hamburger;

	/**
	 */
	public Hesburger()
	{
		hamburger = new Hamburger("Hburgerger");
	}

	@Override
	public String toString()
	{
		return "Hesburger (Hamburger Builder: Object)";
	}

	@Override
	public void buildBun()
	{
		hamburger.addIngredient(new Bun("Gluten Free Bun", 0.62));
	}

	@Override
	public void buildTomato()
	{
		hamburger.addIngredient(new Tomato("Extra Thick Tomato Slice", 0.01));
	}

	@Override
	public void buildLettuce()
	{
		hamburger.addIngredient(new Lettuce("Fresh 'n' Cold", 0.09));
	}

	@Override
	public void buildCheese()
	{
		hamburger.addIngredient(new Cheese("A Slice of Edam Cheese", 0.1));
	}

	@Override
	public void buildPickles()
	{
		hamburger.addIngredient(new Pickles("Slices of Pickles", 0.03));
	}

	@Override
	public void buildPatty()
	{
		hamburger.addIngredient(new Patty("Standard Patty", 0.31));
	}

	/**
	 * Stops building the current {@link Hamburger} and returns the built hamburger.
	 *
	 * @return the final hamburger
	 */
	public Hamburger getHamburger()
	{
		hamburger.addPrice(hamburger.getPrice() * 0.45);
		final Hamburger burger = hamburger;
		hamburger = new Hamburger("Hburgerger");
		return burger;
	}
}
