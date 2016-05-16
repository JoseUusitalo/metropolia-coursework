package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Cap;

/**
 * An Adidas brand {@link Cap}.
 *
 * @author Jose Uusitalo
 */
public class AdidasCap extends Cap
{
	/**
	 */
	public AdidasCap()
	{
		super();
		this.brand = Brands.ADIDAS;
	}
}
