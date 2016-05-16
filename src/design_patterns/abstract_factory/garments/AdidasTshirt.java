package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Tshirt;

/**
 * An Adidas brand {@link Tshirt}.
 *
 * @author Jose Uusitalo
 */
public class AdidasTshirt extends Tshirt
{
	/**
	 */
	public AdidasTshirt()
	{
		super();
		this.brand = Brands.ADIDAS;
	}
}
