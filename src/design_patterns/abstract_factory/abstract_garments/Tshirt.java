package design_patterns.abstract_factory.abstract_garments;

/**
 * A t-shirt.
 *
 * @author Jose Uusitalo
 * @see Garment
 */
public abstract class Tshirt extends AbstractGarment
{
	public Tshirt()
	{
		super();

		this.name = "T-shirt";
	}
}
