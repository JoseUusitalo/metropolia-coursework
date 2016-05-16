package design_patterns.facade.stores;

import design_patterns.facade.goods.FinishedGoods;
import design_patterns.facade.goods.Goods;

/**
 * @author Jose Uusitalo
 */
public class PackingMaterialStore implements Store
{
	@Override
	public Goods getGoods()
	{
		return new FinishedGoods();
	}
}
