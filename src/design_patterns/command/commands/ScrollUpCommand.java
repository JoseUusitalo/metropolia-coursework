package design_patterns.command.commands;

import design_patterns.command.ProjectionScreen;

/**
 * A {@link Command} for scrolling up a {@link ProjectionScreen}.
 *
 * @author Jose Uusitalo
 */
public class ScrollUpCommand implements Command
{
	/**
	 * The {@link ProjectionScreen} this {@link Command} targets.
	 */
	private ProjectionScreen screen;

	/**
	 * @param screen the {@link ProjectionScreen} to be commanded
	 */
	public ScrollUpCommand(final ProjectionScreen screen)
	{
		this.screen = screen;
	}

	@Override
	public void execute()
	{
		screen.scrollUp();
	}
}
