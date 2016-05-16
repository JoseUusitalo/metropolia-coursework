package design_patterns.abstract_factory.garments;

import design_patterns.abstract_factory.Brands;
import design_patterns.abstract_factory.abstract_garments.Cap;

/**
 * A Boss brand {@link Cap}.
 *
 * @author Jose Uusitalo
 */
public class BossCap extends Cap
{
	/**
	 */
	public BossCap()
	{
		super();
		this.brand = Brands.BOSS;
	}
}
