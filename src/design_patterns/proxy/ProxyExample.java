package design_patterns.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Expanded proxy pattern example from Wikipedia.
 *
 * @author Jose Uusitalo
 * @see <a href="https://en.wikipedia.org/wiki/Proxy_pattern#Java">Proxy pattern - Wikipedia</a>
 */
public class ProxyExample
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final List<ProxyImage> directory = new ArrayList<ProxyImage>();
		directory.add(new ProxyImage("HiRes_10MB_Photo1"));
		directory.add(new ProxyImage("HiRes_10MB_Photo2"));
		directory.add(new ProxyImage("cool_photo"));
		directory.add(new ProxyImage("landscape"));
		directory.add(new ProxyImage("my-painting-scan"));

		Iterator<ProxyImage> it = directory.iterator();

		System.out.println("Browsing the directory without loading images.");
		while (it.hasNext())
			it.next().showData();

		System.out.println("\nViewing images in the directory.");
		it = directory.iterator();
		while (it.hasNext())
			it.next().displayImage();

		System.out.println("\nBrowsing again.");
		it = directory.iterator();
		while (it.hasNext())
			it.next().showData();

		System.out.println("\nViewing images in the directory again.");
		it = directory.iterator();
		while (it.hasNext())
			it.next().displayImage();
	}
}
