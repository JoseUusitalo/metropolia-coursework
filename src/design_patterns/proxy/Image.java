package design_patterns.proxy;

/**
 * A picture.
 *
 * @author Jose Uusitalo
 */
interface Image
{
	/**
	 * Show this image on the screen.
	 */
	public void displayImage();

	/**
	 * Shows the file name of this image.
	 */
	public void showData();
}