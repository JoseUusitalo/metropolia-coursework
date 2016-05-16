package design_patterns.adapter;

/**
 * An example implementation of the {@link RGBColor} interface.
 *
 * @author Jose Uusitalo
 */
public class ComponentColor implements RGBColor
{
	/**
	 * An 8-bit unsigned integer representing red.
	 */
	private byte red;

	/**
	 * An 8-bit unsigned integer representing green.
	 */
	private byte green;

	/**
	 * An 8-bit unsigned integer representing blue.
	 */
	private byte blue;

	/**
	 * Creates a component color with the given red, green, and blue values.
	 *
	 * @param red an 8-bit red value
	 * @param green an 8-bit green value
	 * @param blue an 8-bit blue value
	 */
	public ComponentColor(final byte red, final byte green, final byte blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	/**
	 * Gets the component color as an RGB triplet.
	 *
	 * @return a String with the color in the following format: (red,green,blue)
	 */
	@Override
	public String toString()
	{
		return "Component Color: (" + (red & 0xff) + "," + (green & 0xff) + "," + (blue & 0xff) + ")";
	}

	@Override
	public int[] getRGBColor()
	{
		// The "& 0xff" is to do with two's complement and the way Java stores bytes.
		int[] arr = new int[] { (red & 0xff), (green & 0xff), (blue & 0xff) };

		return arr;
	}
}
