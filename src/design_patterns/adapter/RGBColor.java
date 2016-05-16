package design_patterns.adapter;

/**
 * An RGB color interface.
 * The target in the adapter pattern.
 *
 * @author Jose Uusitalo
 */
public interface RGBColor
{
	/**
	 * Gets the color as an integer array.
	 *
	 * @return an integer array of the color values in the following order: red, green, blue
	 */
	public int[] getRGBColor();
}
