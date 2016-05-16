package design_patterns.facade.stores;

import design_patterns.facade.goods.Goods;

/**
 * @author AllAppLabs.com
 * @see <a href="http://www.allapplabs.com/java_design_patterns/facade_pattern.htm">Source</a>
 */
public interface Store
{
	public Goods getGoods();
}
