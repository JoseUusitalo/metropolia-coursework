package modeling_methods;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Proxy pattern example.
 */

class Person
{
}

interface Vacation
{
	public void showInfo();

	public boolean moveVacation(Date start, Date end);
}

@SuppressWarnings("hiding")
class RealVacation implements Vacation
{
	private Person person;
	private Date start;
	private Date end;

	public RealVacation(final Person person, final Date start, final Date end)
	{
		this.person = person;
		this.start = start;
		this.end = end;
		loadFromDatabase();
	}

	private void loadFromDatabase()
	{
		System.out.println("Loading the vacation of " + person + ".");
	}

	private boolean saveToDatabase()
	{
		System.out.println("Saving the vacation of " + person + ".");
		return true;
	}

	@Override
	public void showInfo()
	{
		System.out.println(person + " is on vacation from " + start + " to " + end);
	}

	@Override
	public boolean moveVacation(final Date start, final Date end)
	{
		this.start = start;
		this.end = end;
		return saveToDatabase();
	}
}

@SuppressWarnings({ "static-method", "hiding", "unused" })
class ProxyVacation implements Vacation
{
	private RealVacation vacation;
	private Person person;
	private Date start;
	private Date end;

	public ProxyVacation(final Person person, final Date start, final Date end)
	{
		this.person = person;
		this.start = start;
		this.end = end;
	}

	private boolean checkDates(final Date start, final Date end)
	{
		// Do the check.
		return true;
	}

	@Override
	public boolean moveVacation(final Date newStart, final Date newEnd)
	{
		if (checkDates(newStart, newEnd))
		{
			if (vacation == null)
			{
				vacation = new RealVacation(person, newStart, newEnd);
			}
			return vacation.moveVacation(newStart, newEnd);
		}
		return false;
	}

	@Override
	public void showInfo()
	{
		if (vacation == null)
		{
			vacation = new RealVacation(person, start, end);
		}
		vacation.showInfo();
	}
}

public class ProxyPattern
{
	public static void main(final String[] args)
	{
		Calendar start = new GregorianCalendar(2016, 5, 1);
		Calendar end = new GregorianCalendar(2016, 5, 20);

		final Person person = new Person();
		final Vacation vacation = new ProxyVacation(person, start.getTime(), end.getTime());

		// Data is loaded from the database.
		vacation.showInfo();
		System.out.println();

		// Data is already loaded to memory.
		vacation.showInfo();
		System.out.println();

		// Changing dates.
		end.set(2016, 6, 2);

		// Database and the proxy object is changed.
		vacation.moveVacation(start.getTime(), end.getTime());

		// Data is already loaded to memory.
		vacation.showInfo();
	}
}
