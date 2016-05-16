package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Jeans;

/**
 * A pair of Adidas brand {@link Jeans}.
 *
 * @author Jose Uusitalo
 */
public class AdidasJeans extends Jeans
{
	/**
	 */
	public AdidasJeans()
	{
		super();
		this.brand = Brands.ADIDAS;
	}
}
