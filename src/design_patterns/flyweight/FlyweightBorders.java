package design_patterns.flyweight;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 * Flyweight pattern in Java Swing {@link Border} class.
 * Code copied from <a
 * href="http://www.javaworld.com/article/2073632/build-ci-sdlc/make-your-apps-fly.html">JavaWorld</a>.
 *
 * @author David Geary
 */
public class FlyweightBorders extends JFrame
{
	private static final long serialVersionUID = 1L;

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		FlyweightBorders test = new FlyweightBorders();
		test.setBounds(20, 20, 250, 150);
		test.setVisible(true);
	}

	public FlyweightBorders()
	{
		super("Border flyweights");
		JPanel panel = new JPanel(), panel2 = new JPanel();
		Border border = BorderFactory.createRaisedBevelBorder();
		Border border2 = BorderFactory.createRaisedBevelBorder();
		panel.setBorder(border);
		panel.setPreferredSize(new Dimension(100, 100));
		panel2.setBorder(border2);
		panel2.setPreferredSize(new Dimension(100, 100));
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(panel);
		contentPane.add(panel2);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(final WindowEvent e)
			{
				System.exit(0);
			}
		});

		if (border == border2)
			System.out.println("bevel borders are shared");
		else
			System.out.println("bevel borders are NOT shared");
	}
}
