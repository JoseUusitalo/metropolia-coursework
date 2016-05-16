package design_patterns.adapter;

/**
 * A composite color value with the red, green, and blue bits in a single integer.
 * The adaptee in the adapter pattern.
 *
 * @author Jose Uusitalo
 */
public class CompositeColor
{
	/**
	 * A 32-bit unsigned integer containing the 8-bit red, green and blue color data.
	 */
	private int rgbComposite;

	/**
	 * Creates a composite color.
	 *
	 * @param rgbComposite an unsigned 32-bit integer where the 8-bit blue, green, and red values are in that order
	 *            and the first 8-bits of the number are ignored
	 */
	public CompositeColor(final int rgbComposite)
	{
		this.rgbComposite = rgbComposite;
	}

	/**
	 * Gets the composite color info and the legend in readable format.
	 *
	 * @return a String with the color data
	 */
	@Override
	public String toString()
	{
		return "Binary: " + getColorBinary() + "\nLegend: --------|     BLU|     GRN|     RED";
	}

	/**
	 * Converts the composite color value into binary.
	 *
	 * @return a sectioned binary representation of the composite color
	 */
	private String getColorBinary()
	{
		final String binary = String.format("%32s", Integer.toBinaryString(rgbComposite)).replace(' ', '0');
		final StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 32; i += 8)
		{
			sb.append(binary.substring(i, i + 8));

			if (i < 32 - 8)
				sb.append("|");
		}

		return sb.toString();
	}

	/**
	 * Gets the 32-bit (unsigned) integer containing the 8-bit blue, green and red color data (in that order when read
	 * from left to right) with the first 8 bits ignored.
	 *
	 * @return the composite color value.
	 */
	public int getCompositeColor()
	{
		return rgbComposite;
	}

	/**
	 * Inverts the color by inverting the bit pattern.
	 */
	public void invert()
	{
		rgbComposite = ~rgbComposite;
	}
}
