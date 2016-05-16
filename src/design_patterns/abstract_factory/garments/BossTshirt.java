package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Tshirt;

/**
 * A Boss brand {@link Tshirt}.
 *
 * @author Jose Uusitalo
 */
public class BossTshirt extends Tshirt
{
	/**
	 */
	public BossTshirt()
	{
		super();
		this.brand = Brands.BOSS;
	}
}
