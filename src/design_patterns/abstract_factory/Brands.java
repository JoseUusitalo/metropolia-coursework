package design_patterns.abstract_factory;

/**
 * Valid clothing brands.
 *
 * @author Jose Uusitalo
 */
public enum Brands
{
	/**
	 * The Adidas brand.
	 */
	ADIDAS,
	
	/**
	 * The Boss brand.
	 */
	BOSS;

	/**
	 * @return the name of this brand in capital letters followed by the trademark symbol
	 */
	@Override
	public String toString()
	{
		return this.name() + "™";
	}
}
