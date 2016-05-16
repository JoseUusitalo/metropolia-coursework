package design_patterns.facade.stores;

import design_patterns.facade.goods.Goods;
import design_patterns.facade.goods.RawMaterialGoods;

/**
 * @author AllAppLabs.com
 * @see <a href="http://www.allapplabs.com/java_design_patterns/facade_pattern.htm">Source</a>
 */
public class RawMaterialStore implements Store
{
	@Override
	public Goods getGoods()
	{
		return new RawMaterialGoods();
	}
}
