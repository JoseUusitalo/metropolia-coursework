package design_patterns.abstract_factory.factories;

import design_patterns.abstract_factory.abstract_garments.Garment;
import design_patterns.abstract_factory.garments.BossCap;
import design_patterns.abstract_factory.garments.BossJeans;
import design_patterns.abstract_factory.garments.BossShoes;
import design_patterns.abstract_factory.garments.BossTshirt;

/**
 * A factory that creates Boss brand clothes.
 *
 * @author Jose Uusitalo
 */
public class BossFactory implements GarmentFactory
{
	@Override
	public Garment createCap()
	{
		return new BossCap();
	}

	@Override
	public Garment createTShirt()
	{
		return new BossTshirt();
	}

	@Override
	public Garment createJeans()
	{
		return new BossJeans();
	}

	@Override
	public Garment createShoes()
	{
		return new BossShoes();
	}
}
