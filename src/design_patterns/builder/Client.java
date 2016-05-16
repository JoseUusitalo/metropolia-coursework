package design_patterns.builder;

import design_patterns.builder.builders.HamburgerBuilder;
import design_patterns.builder.builders.Hesburger;
import design_patterns.builder.builders.McDonalds;
import design_patterns.builder.ingredients.Hamburger;

/**
 * An example of the builder pattern with hamburgers.
 *
 * @author Jose Uusitalo
 */
public class Client
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final RecipeMaster director = new RecipeMaster();

		HamburgerBuilder builder = new Hesburger();
		director.setBuilder(builder);

		System.out.println("The client asks the " + director + " to build a " + builder + " hamburger.");
		director.buildHamburger();
		final Hamburger burger = ((Hesburger) builder).getHamburger();
		System.out.println();

		System.out.println("Client received the following hamburger: " + burger);
		burger.printReceipt();
		System.out.println();

		System.out.println(" ---- \n");

		builder = new McDonalds();
		director.setBuilder(builder);

		System.out.println("The client asks the " + director + " to build a " + builder + " hamburger.");
		director.buildHamburger();
		System.out.println();

		String burger2 = ((McDonalds) builder).getHamburger();
		System.out.println("Client received the following hamburger:\n" + burger2);
	}
}
