package design_patterns.command;

import java.util.ArrayList;
import java.util.List;

import design_patterns.command.commands.Command;

/**
 * A smart button that stores the {@link Command}s it executes in memory.
 *
 * @author Jose Uusitalo
 */
public class Button
{
	/**
	 * A history of {@link Command}s executed using this switch.
	 */
	private List<design_patterns.command.commands.Command> history = new ArrayList<Command>();

	/**
	 * Executes the specified {@link Command}.
	 *
	 * @param cmd command to be executed
	 */
	public void storeAndExecute(final Command cmd)
	{
		this.history.add(cmd);
		cmd.execute();
	}

	/**
	 * Gets the history of {@link Command}s executed with this button.
	 *
	 * @return a list of commands
	 */
	public List<Command> getHistory()
	{
		return history;
	}
}
