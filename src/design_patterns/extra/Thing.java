package design_patterns.extra;

/**
 * A class that implements two interface that both declare a default method with the same name.
 *
 * @author Jose Uusitalo
 */
public class Thing implements IOne, ITwo
{
	@Override
	public void doTheThing()
	{
		IOne.super.doTheThing();
	}
}
