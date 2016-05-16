package design_patterns.template_method;

/**
 * Play Tic-Tac-Toe.
 * 
 * @author Jose Uusitalo
 */
public class PlayGame
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final TicTacToe ttt = new TicTacToe();
		ttt.playOneGame(2);
	}
}
