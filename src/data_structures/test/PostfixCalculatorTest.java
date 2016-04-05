package data_structures.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data_structures.code.PostfixCalculator;

/**
 * Tests for the {@link PostfixCalculator} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class PostfixCalculatorTest
{
	@Test
	public final void testAddition()
	{
		System.out.println("Addition");
		assertEquals(1 + 2, PostfixCalculator.calculate("1 2 +"), 0.001);
	}

	@Test
	public final void testSubtraction()
	{
		System.out.println("Substraction");
		assertEquals(2 - 3, PostfixCalculator.calculate("2 3 -"), 0.001);
	}

	@Test
	public final void testMultiplication()
	{
		System.out.println("Multiplication");
		assertEquals(5 * 8, PostfixCalculator.calculate("5 8 *"), 0.001);
	}

	@Test
	public final void testChaining()
	{
		System.out.println("Chaining");
		assertEquals(2 * 3 - 4, PostfixCalculator.calculate("2 3 * 4 -"), 0.001);
	}

	@Test
	public final void testDivision()
	{
		assertEquals(21.0 / 13.0, PostfixCalculator.calculate("21 13 /"), 0.001);
	}

	@Test
	public final void testLong()
	{
		System.out.println("Long test");
		assertEquals((3.0 + 4.0) * (5.0 / 2.0), PostfixCalculator.calculate("3 4 + 5 2 / *"), 0.001);
	}

	@Test
	public final void testLong2()
	{
		System.out.println("Long test 2");
		assertEquals((1.0 * 1.2 - 1.3 - 1.4) / (2.0 + 2.1) * (3.0 / 3.1), PostfixCalculator.calculate("1 1.2 * 1.3 - 1.4 - 2 2.1 + / 3 3.1 / *"), 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void testInvalid()
	{
		PostfixCalculator.calculate("21 13 ^");
	}

	@Test(expected = IllegalArgumentException.class)
	public final void testInvalid2()
	{
		PostfixCalculator.calculate("asdf");
	}

	@Test
	public final void testEmpty()
	{
		assertEquals(0, PostfixCalculator.calculate(" "), 0.001);
	}

	@Test
	public final void testSingle()
	{
		assertEquals(2.0, PostfixCalculator.calculate("     2     "), 0.001);
	}
}
