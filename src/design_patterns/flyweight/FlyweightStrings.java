package design_patterns.flyweight;

/**
 * Flyweight pattern in Java {@link String} class.
 * Code copied from <a
 * href="http://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html">JavaWorld</a>.
 *
 * @author David Geary
 */
public class FlyweightStrings
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		String fly = "fly", weight = "weight";
		String fly2 = "fly", weight2 = "weight";
		System.out.println(fly == fly2); // fly and fly2 refer to the same String instance
		System.out.println(weight == weight2); // weight and weight2 also refer to
												// the same String instance
		String distinctString = fly + weight;
		System.out.println(distinctString == "flyweight"); // flyweight and "flyweight" do not
															// refer to the same instance
		String flyweight = (fly + weight).intern();
		System.out.println(flyweight == "flyweight"); // The intern() method returns a flyweight
	}
}
