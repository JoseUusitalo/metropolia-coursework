package design_patterns.flyweight.lines;

import java.awt.Color;
import java.util.HashMap;

/**
 * A flyweight object factory.
 * Code copied from <a
 * href="http://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html?page=2">JavaWorld</a>.
 *
 * @author David Geary
 */
public class LineFactory
{
	private static final HashMap<Color, Line> linesByColor = new HashMap<Color, Line>();

	public static Line getLine(final Color color)
	{
		Line line = linesByColor.get(color);

		if (line == null)
		{
			line = new Line(color);
			linesByColor.put(color, line);
			System.out.println("Creating " + color + " line");
		}

		return line;
	}
}
