import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new Rectangle("test2", 3, 4);
		Shape c = new Rectangle("test3", 4,4);
		Shape d = new Rectangle("test4", 4, 4);

		sorter.addShape(b);
		sorter.addShape(d);
		sorter.addShape(a);
		sorter.addShape(c);
		sorter.sortShapes();
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(2), d);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(3), c);
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new Rectangle("test2", 3, 4);
		Shape c = new Rectangle("test3", 4, 4);
		Shape d = new Rectangle("test4", 4, 4);

		ShapeAreaComparator e = new ShapeAreaComparator();
		sorter.addShape(b);
		sorter.addShape(d);
		sorter.addShape(a);
		sorter.addShape(c);
		sorter.sortShapes(e);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(2), d);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(3), c);
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new Rectangle("test2", 3, 4);
		Shape c = new Rectangle("test3", 4,4);
		Shape d = new Rectangle("test4", 4, 4);

		ShapePerimeterComparator e = new ShapePerimeterComparator();
		sorter.addShape(b);
		sorter.addShape(d);
		sorter.addShape(a);
		sorter.addShape(c);
		sorter.sortShapes(e);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(2), d);
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(3), c);
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		Shape a = new Rectangle("test", 3, 3);
		Shape b = new Rectangle("test2", 3, 4);
		Shape c = new Rectangle("test3", 4,4);
		Shape d = new Rectangle("test4", 4, 4);

		ShapePerimeterComparator e = new ShapePerimeterComparator();
		sorter.addShape(b);
		sorter.addShape(d);
		sorter.addShape(a);
		sorter.addShape(c);
		sorter.sortShapes(e);
		Assert.assertEquals("Sorter toString() incorrect...", a.toString()+b.toString()+d.toString()+c.toString(), sorter.toString());
	}
}
