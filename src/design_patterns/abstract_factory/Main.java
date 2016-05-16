package design_patterns.abstract_factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import design_patterns.abstract_factory.factories.GarmentFactory;

/**
 * Exercise 2: Abstract Factory
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * The properties data.
	 */
	private static Properties properties;

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final GarmentFactory oldFactory = getOldFactory();
		final GarmentFactory newFactory = getNewFactory();
		final Person jasper = new Person("Jasper");

		System.out.println(jasper + " is in school...\n");

		jasper.listGarments();

		System.out.println("\nPutting on some clothes.");
		jasper.wearBrand(oldFactory);
		jasper.listGarments();

		System.out.println("\nAfter graduation...\n");

		System.out.println("Changing clothes.");
		jasper.strip();
		jasper.listGarments();

		System.out.println("\nNew clothes!");
		jasper.wearBrand(newFactory);
		jasper.listGarments();
	}

	/**
	 * Loads the properties from the properties file into memory.
	 */
	private static void loadProperties()
	{
		properties = new Properties();

		try
		{
			FileInputStream in = new FileInputStream("src/abstract_factory/clothing.properties");
			properties.load(in);
			in.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Gets the {@link GarmentFactory} from the properties file with the specified key.
	 *
	 * @param key the proeprty key
	 * @return a new garment factory object
	 */
	private static GarmentFactory getGarmentFactory(final String key)
	{
		if (properties == null)
			loadProperties();

		try
		{
			return (GarmentFactory) Class.forName(properties.getProperty(key)).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Gets the correct class from the properties to be the old clothing factory.
	 *
	 * @return the old clothing factory
	 */
	private static GarmentFactory getOldFactory()
	{
		return getGarmentFactory("oldFactory");
	}

	/**
	 * Gets the correct class from the properties to be the new clothing factory.
	 *
	 * @return the new clothing factory
	 */
	private static GarmentFactory getNewFactory()
	{
		return getGarmentFactory("newFactory");
	}
}
