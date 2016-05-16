package design_patterns.proxy;

/**
 * The actual image class that handles loading data from disk.
 *
 * @author Jose Uusitalo
 */
class RealImage implements Image
{
	/**
	 * The file path of this image.
	 */
	private String filepath = null;

	/**
	 * @param filepath the file path of this image
	 */
	public RealImage(final String filepath)
	{
		this.filepath = filepath;

		loadImageFromDisk();
	}

	/**
	 * Loads the image from the disk.
	 */
	private void loadImageFromDisk()
	{
		System.out.println("Loading...\t" + filepath);
	}

	/**
	 * Displays the image.
	 */
	@Override
	public void displayImage()
	{
		System.out.println("Displaying\t" + filepath);
	}

	@Override
	public void showData()
	{
		System.out.println(filepath);
	}
}
