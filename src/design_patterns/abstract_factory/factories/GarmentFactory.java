package design_patterns.abstract_factory.factories;

import design_patterns.abstract_factory.abstract_garments.Garment;

/**
 * An abstract factory for creating clothing.
 *
 * @author Jose Uusitalo
 */
public interface GarmentFactory
{
	/**
	 * Creates a new cap of some brand.
	 *
	 * @return a new cap
	 */
	public abstract Garment createCap();

	/**
	 * Creates a t-shirt of some brand.
	 *
	 * @return a new t-shirt
	 */
	public abstract Garment createTShirt();

	/**
	 * Creates a pair of jeans of some brand.
	 *
	 * @return a new pair of jeans
	 */
	public abstract Garment createJeans();

	/**
	 * Creates a pair of shoes of some brand.
	 *
	 * @return a new pair of shoes
	 */
	public abstract Garment createShoes();
}
