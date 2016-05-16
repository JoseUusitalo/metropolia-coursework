package design_patterns.abstract_factory.abstract_garments;

import design_patterns.abstract_factory.Brands;

/**
 * An article of clothing.
 *
 * @author Jose Uusitalo
 */
public abstract class AbstractGarment implements Garment
{
	/**
	 * The brand of this garment.
	 */
	protected Brands brand;

	/**
	 * The name of this piece of clothing.
	 */
	protected String name;

	/**
	 * @return the name of this garment
	 */
	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public Brands getBrand()
	{
		return brand;
	}
}
