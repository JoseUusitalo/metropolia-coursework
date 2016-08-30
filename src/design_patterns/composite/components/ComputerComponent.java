package design_patterns.composite.components;

/**
 * A computer component that has a price.
 *
 * @author Jose Uusitalo
 */
public interface ComputerComponent
{
	/**
	 * Attach a new component to this component.
	 *
	 * @param component component to attach
	 * @return <code>true</code> if the component was not present in this component and was attached successfully
	 */
	public default boolean attach(final ComputerComponent component)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Detach the given component from this component.
	 *
	 * @param component component to detach
	 * @return <code>true</code> if the component was present in this component and was detached successfully
	 */
	public default boolean detach(final ComputerComponent component)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the price of this component in euros.
	 *
	 * @return the price of this component
	 */
	public abstract double getPrice();
}
