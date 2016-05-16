package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Shoes;

/**
 * A pair of Adidas brand {@link Shoes}.
 *
 * @author Jose Uusitalo
 */
public class AdidasShoes extends Shoes
{
	/**
	 */
	public AdidasShoes()
	{
		super();
		this.brand = Brands.ADIDAS;
	}
}
