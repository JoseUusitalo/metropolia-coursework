package design_patterns.facade;

import design_patterns.facade.goods.FinishedGoods;
import design_patterns.facade.goods.PackingMaterialGoods;
import design_patterns.facade.goods.RawMaterialGoods;
import design_patterns.facade.stores.FinishedGoodsStore;
import design_patterns.facade.stores.PackingMaterialStore;
import design_patterns.facade.stores.RawMaterialStore;

/**
 * @author AllAppLabs.com
 * @see <a href="http://www.allapplabs.com/java_design_patterns/facade_pattern.htm">Source</a>
 */
@SuppressWarnings("static-method")
public class StoreKeeper
{
	/**
	 * The raw materials are asked for and
	 * are returned
	 *
	 * @return raw materials
	 */
	public RawMaterialGoods getRawMaterialGoods()
	{
		RawMaterialStore store = new RawMaterialStore();
		RawMaterialGoods rawMaterialGoods = (RawMaterialGoods) store.getGoods();
		return rawMaterialGoods;
	}

	/**
	 * The packaging materials are asked for and
	 * are returned
	 *
	 * @return packaging materials
	 */
	public PackingMaterialGoods getPackingMaterialGoods()
	{
		PackingMaterialStore store = new PackingMaterialStore();
		PackingMaterialGoods packingMaterialGoods = (PackingMaterialGoods) store.getGoods();
		return packingMaterialGoods;
	}

	/**
	 * The finished goods are asked for and
	 * are returned
	 *
	 * @return finished goods
	 */
	public FinishedGoods getFinishedGoods()
	{
		FinishedGoodsStore store = new FinishedGoodsStore();
		FinishedGoods finishedGoods = (FinishedGoods) store.getGoods();
		return finishedGoods;
	}
}
