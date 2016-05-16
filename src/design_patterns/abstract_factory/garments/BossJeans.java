package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Jeans;

/**
 * A pair of Boss brand {@link Jeans}.
 *
 * @author Jose Uusitalo
 */
public class BossJeans extends Jeans
{
	/**
	 */
	public BossJeans()
	{
		super();
		this.brand = Brands.BOSS;
	}
}
