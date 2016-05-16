package design_patterns.command;

import java.util.Random;

import design_patterns.command.commands.Command;
import design_patterns.command.commands.ScrollDownCommand;
import design_patterns.command.commands.ScrollUpCommand;

/**
 * A command pattern example with a user that plays with a {@link Button} to manipulate a {@link ProjectionScreen} for their own amusement.
 *
 * @author Jose Uusitalo
 */
public class User
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final Random random = new Random();

		final ProjectionScreen screen = new ProjectionScreen();
		final Command switchUp = new ScrollUpCommand(screen);
		final Command switchDown = new ScrollDownCommand(screen);
		final Button button = new Button();

		for (int i = 0; i < 5; i++)
		{
			System.out.println("A user presses the button.");

			if (random.nextBoolean())
				button.storeAndExecute(switchUp);
			else
				button.storeAndExecute(switchDown);

			try
			{
				Thread.sleep(1000L);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("\nThe button has executed the following commands:");

		for (final Command cmd : button.getHistory())
			System.out.println(cmd);
	}
}
