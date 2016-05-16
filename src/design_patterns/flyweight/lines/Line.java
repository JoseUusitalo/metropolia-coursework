package design_patterns.flyweight.lines;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A flyweight object.
 * Code copied from <a
 * href="http://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html?page=2">JavaWorld</a>.
 *
 * @author David Geary
 */
public class Line
{
	private Color color;

	public Line(final Color color)
	{
		this.color = color;
	}

	public void draw(final Graphics g, final int x, final int y, final int x2, final int y2)
	{
		g.setColor(color);
		g.drawLine(x, y, x2, y2);
	}
}