package design_patterns.factory_method;

import design_patterns.factory_method.abstracts.FeedingCreature;
import design_patterns.factory_method.implementations.Headmaster;
import design_patterns.factory_method.implementations.Student;
import design_patterns.factory_method.implementations.Teacher;

/**
 * Exercise 1: Factory Method
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		System.out.println("Headmaster");
		FeedingCreature headmaster = new Headmaster();
		headmaster.feed();
		System.out.println();

		System.out.println("Teacher");
		FeedingCreature teacher = new Teacher();
		teacher.feed();
		System.out.println();

		System.out.println("Student");
		FeedingCreature student = new Student();
		student.feed();
		System.out.println();
	}
}
