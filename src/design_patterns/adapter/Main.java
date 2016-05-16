package design_patterns.adapter;

/**
 * The client in the adapter pattern.
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * An example composite color value.
	 */
	private final static int compositeColorValue = 112358;

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		previewComponentColor();
		System.out.println();

		previewCompositeColor();
		System.out.println();

		previewAdapter();
		System.out.println();

		previewInvertComposite();
		System.out.println();

		previewInvertAdapter();
	}

	/**
	 * Shows an example with the {@link RGBColor} target interface.
	 */
	private static void previewComponentColor()
	{
		System.out.println("---- Example With a Component Color ----");

		final byte red = (byte) 128;
		final byte green = (byte) 255;
		final byte blue = 20;
		final ComponentColor component = new ComponentColor(red, green, blue);

		System.out.println(component);
		System.out.println("Color values:");

		printRGB(component.getRGBColor());
	}

	/**
	 * Shows how the adaptee works.
	 */
	private static void previewCompositeColor()
	{
		System.out.println("---- Composite Color ----");
		final CompositeColor composite = new CompositeColor(compositeColorValue);

		System.out.println("The composite color is: " + composite.getCompositeColor());
		System.out.println(composite);
	}

	/**
	 * Shows how the adapter works.
	 */
	private static void previewAdapter()
	{
		System.out.println("---- Adapter Color ----");
		System.out.println("Using an adapter to print the previous composite color values separately.");
		final CompositeColorAdapter adapter = new CompositeColorAdapter(compositeColorValue);

		System.out.println("The composite adapter composite color is: " + adapter.getCompositeColor());
		System.out.println("Color RGB values:");

		printRGB(adapter.getRGBColor());
	}

	/**
	 * Shows how the {@link CompositeColor#invert()} works.
	 */
	private static void previewInvertComposite()
	{
		System.out.println("---- Inverted Composite Color ----");
		final CompositeColor composite = new CompositeColor(compositeColorValue);

		composite.invert();
		System.out.println("The composite color inverted: " + composite.getCompositeColor());
		System.out.println(composite);
	}

	/**
	 * Shows the use of a {@link CompositeColor#invert()} method with the {@link CompositeColorAdapter}.
	 */
	private static void previewInvertAdapter()
	{
		System.out.println("---- Inverted Adapter Color ----");
		final CompositeColorAdapter adapter = new CompositeColorAdapter(compositeColorValue);

		adapter.invert();
		System.out.println("Adapter color inverted: " + adapter.getCompositeColor());
		System.out.println("Color RGB values:");

		printRGB(adapter.getRGBColor());
	}

	/**
	 * Prints the given integer array containing an RGB color.
	 *
	 * @param rgbColor an array of red, green, and blue values
	 */
	private static void printRGB(final int[] rgbColor)
	{
		for (int i = 0; i < 3; i++)
		{
			if (i == 0)
				System.out.println("R: " + rgbColor[i]);
			else if (i == 1)
				System.out.println("G: " + rgbColor[i]);
			else
				System.out.println("B: " + rgbColor[i]);
		}
	}
}
