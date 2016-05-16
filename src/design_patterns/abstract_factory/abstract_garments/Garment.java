package design_patterns.abstract_factory.abstract_garments;

import design_patterns.abstract_factory.Brands;

/**
 * A generic garment interface.
 *
 * @author Jose Uusitalo
 */
public interface Garment
{
	/**
	 * Gets the {@link Brands} of this garment.
	 *
	 * @return the brand of this garment
	 */
	public abstract Brands getBrand();
}
