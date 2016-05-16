package design_patterns.abstract_factory.factories;

import design_patterns.abstract_factory.abstract_garments.Garment;
import design_patterns.abstract_factory.garments.AdidasCap;
import design_patterns.abstract_factory.garments.AdidasJeans;
import design_patterns.abstract_factory.garments.AdidasShoes;
import design_patterns.abstract_factory.garments.AdidasTshirt;

/**
 * A factory that creates Adidas brand clothes.
 *
 * @author Jose Uusitalo
 */
public class AdidasFactory implements GarmentFactory
{
	@Override
	public Garment createCap()
	{
		return new AdidasCap();
	}

	@Override
	public Garment createTShirt()
	{
		return new AdidasTshirt();
	}

	@Override
	public Garment createJeans()
	{
		return new AdidasJeans();
	}

	@Override
	public Garment createShoes()
	{
		return new AdidasShoes();
	}
}
