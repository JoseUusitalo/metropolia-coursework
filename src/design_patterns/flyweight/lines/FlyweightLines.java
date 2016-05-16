package design_patterns.flyweight.lines;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Drawing lines using the flyweight pattern.
 * Code copied from <a
 * href="http://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html">JavaWorld</a>.
 *
 * @author David Geary
 */
public class FlyweightLines extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final Color colors[] = { Color.red, Color.blue, Color.yellow, Color.orange, Color.black, Color.white };
	private static final int WINDOW_WIDTH = 1000, WINDOW_HEIGHT = 800, NUMBER_OF_LINES = 1000000;

	public FlyweightLines()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		JButton button = new JButton("draw lines");
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.SOUTH);
		setBounds(20, 20, WINDOW_WIDTH, WINDOW_HEIGHT);

		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent event)
			{
				Graphics g = panel.getGraphics();
				for (int i = 0; i < NUMBER_OF_LINES; ++i)
				{
					Line line = LineFactory.getLine(getRandomColor());
					line.draw(g, getRandomX(), getRandomY(), getRandomX(), getRandomY());
				}
			}
		});
	}

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		FlyweightLines test = new FlyweightLines();
		test.setVisible(true);
	}

	@SuppressWarnings("static-method")
	private int getRandomX()
	{
		return (int) (Math.random() * WINDOW_WIDTH);
	}

	@SuppressWarnings("static-method")
	private int getRandomY()
	{
		return (int) (Math.random() * WINDOW_HEIGHT);
	}

	@SuppressWarnings("static-method")
	private Color getRandomColor()
	{
		return colors[(int) (Math.random() * colors.length)];
	}
}
