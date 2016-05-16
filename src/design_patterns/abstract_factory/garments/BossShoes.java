package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Shoes;

/**
 * A pair of Boss brand {@link Shoes}.
 *
 * @author Jose Uusitalo
 */
public class BossShoes extends Shoes
{
	/**
	 */
	public BossShoes()
	{
		super();
		this.brand = Brands.BOSS;
	}
}
