package design_patterns.proxy;

/**
 * A proxy for the {@link RealImage} class.
 *
 * @author Jose Uusitalo
 */
public class ProxyImage implements Image
{
	/**
	 * The actual image that this class is a proxy for.
	 */
	private RealImage image;

	/**
	 * The file path of the real image.
	 */
	private String filepath;

	/**
	 * @param filepath the file path to the real image
	 */
	public ProxyImage(final String filepath)
	{
		this.filepath = filepath;
	}

	/**
	 * Displays the image
	 */
	@Override
	public void displayImage()
	{
		if (image == null)
			image = new RealImage(filepath);

		image.displayImage();
	}

	@Override
	public void showData()
	{
		if (image == null)
			System.out.println("Proxy: " + filepath);
		else
			image.showData();
	}
}
