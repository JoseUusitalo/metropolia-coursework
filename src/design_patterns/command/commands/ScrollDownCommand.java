package design_patterns.command.commands;

import design_patterns.command.ProjectionScreen;

/**
 * A {@link Command} for scrolling down a {@link ProjectionScreen}.
 *
 * @author Jose Uusitalo
 */
public class ScrollDownCommand implements Command
{
	/**
	 * The {@link ProjectionScreen} the {@link Command} targets.
	 */
	private ProjectionScreen screen;

	/**
	 * @param screen the {@link ProjectionScreen} to be commanded
	 */
	public ScrollDownCommand(final ProjectionScreen screen)
	{
		this.screen = screen;
	}

	@Override
	public void execute()
	{
		screen.scrollDown();
	}
}
