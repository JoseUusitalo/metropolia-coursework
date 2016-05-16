package design_patterns.facade;

import design_patterns.facade.goods.RawMaterialGoods;

/**
 * @author AllAppLabs.com
 * @see <a href="http://www.allapplabs.com/java_design_patterns/facade_pattern.htm">Source</a>
 */
public class Client
{
	/**
	 * to get raw materials
	 *
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		StoreKeeper keeper = new StoreKeeper();

		RawMaterialGoods rawMaterialGoods = keeper.getRawMaterialGoods();

		System.out.println(rawMaterialGoods);
	}
}
