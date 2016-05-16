package design_patterns.facade.stores;

import design_patterns.facade.goods.FinishedGoods;
import design_patterns.facade.goods.Goods;

/**
 * @author AllAppLabs.com
 * @see <a href="http://www.allapplabs.com/java_design_patterns/facade_pattern.htm">Source</a>
 */
public class FinishedGoodsStore implements Store
{
	@Override
	public Goods getGoods()
	{
		FinishedGoods finishedGoods = new FinishedGoods();
		return finishedGoods;
	}
}
