package design_patterns.adapter;

/**
 * An adapter that allows using the {@link CompositeColor} class with the {@link RGBColor} interface.
 * The adapter in the adapter pattern.
 *
 * @author Jose Uusitalo
 */
public class CompositeColorAdapter extends CompositeColor implements RGBColor
{
	/**
	 * @param rgbComposite the RGB composite value to be adapted
	 * @see CompositeColor#CompositeColor(int)
	 */
	public CompositeColorAdapter(final int rgbComposite)
	{
		super(rgbComposite);
	}

	@Override
	public int[] getRGBColor()
	{
		// This can be done with bit shifting but I'm not that skilled yet so I'm taking the easier route.
		final String binary = toZeroPaddedBinaryString(getCompositeColor());
		final int[] arr = new int[3];

		/*
		 * Ignore the first byte, the would-be 4th element.
		 * The composite color values are reversed, so the first color read is actually last in the array.
		 * Convert the byte to int.
		 */
		for (int i = 8; i < 32; i += 8)
			arr[3 - (i / 8)] = binaryStringToInt(binary.substring(i, i + 8));

		return arr;
	}

	/**
	 * Converts the given 32-bit integer into its binary representation with leading zeroes.
	 *
	 * @param value the integer value
	 * @return a binary representation of the value
	 */
	@SuppressWarnings("static-method")
	private String toZeroPaddedBinaryString(final int value)
	{
		return String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');
	}

	/**
	 * Converts the given string of binary data into an int.
	 *
	 * @param binary string of 1s and 0s
	 * @return an integer value
	 */
	@SuppressWarnings("static-method")
	private int binaryStringToInt(final String binary)
	{
		return Integer.parseInt(binary, 2);
	}
}
