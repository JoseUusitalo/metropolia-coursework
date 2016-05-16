package design_patterns.abstract_factory;

import java.util.HashSet;
import java.util.Set;

import design_patterns.abstract_factory.abstract_garments.Garment;
import design_patterns.abstract_factory.factories.GarmentFactory;

/**
 * A person who can wear clothes.
 *
 * @author Jose Uusitalo
 */
public class Person
{
	/**
	 * The name of this person.
	 */
	private String name;

	/**
	 * The clothes this person is wearing.
	 */
	private Set<Garment> clothes;

	/**
	 * @param name the name of this person
	 */
	public Person(final String name)
	{
		this.name = name;
		clothes = new HashSet<Garment>();
	}

	/**
	 * @return the name of this person
	 */
	@Override
	public String toString()
	{
		return name;
	}

	/**
	 * Wears a full set of clothing provided by the given {@link GarmentFactory}.
	 *
	 * @param factory the factory to get the clothes from
	 */
	public void wearBrand(final GarmentFactory factory)
	{
		clothes.add(factory.createCap());
		clothes.add(factory.createTShirt());
		clothes.add(factory.createJeans());
		clothes.add(factory.createShoes());
	}

	/**
	 * Removes all clothes.
	 */
	public void strip()
	{
		clothes.clear();
	}

	/**
	 * Prints out each piece of clothing this person is wearing.
	 */
	public void listGarments()
	{
		System.out.println(name + " is wearing:");

		if (clothes.isEmpty())
			System.out.println("Nothing.");
		else
			clothes.forEach((final Garment g) -> System.out.println("- " + g.getBrand() + " " + g));
	}
}
