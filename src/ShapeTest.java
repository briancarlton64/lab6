import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
		Shape sqr1 = new Square("Square1", 3.0, 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr1.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr1.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr1.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr1.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape sqr = new Rectangle("Rectangle1", 3.0, 4);
		Assert.assertEquals("Rectangle area incorrect.", 12, sqr.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 14, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", sqr.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape sqr = new EquilateralTriangle("Triangle1", 4);
		Assert.assertEquals("Triangle area incorrect.", 16*Math.sqrt(3)/4, sqr.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 12, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Triangle1", sqr.getId());	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape sqr = new Trapezoid("Trapezoid1", 1,1,4,5);
		Assert.assertEquals("Trapezoid area incorrect.", 3.8971143, sqr.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 11, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", sqr.getId());	
		}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());
		Assert.assertEquals("Ellipse major axis incorrect.", 3.0, ((Ellipse) circ).getMajorAxis(),0.0001);


		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape circ = new Circle("Circle1", 3.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Circle perimeter incorrect.",
				2 * Math.PI *3,
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", circ.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape circ = new Circle("Circle1", 3.0);
		Assert.assertEquals("Circle toString incorrect.", "Circle\t ID = Circle1\t area = "+String.format("%.3f", (3*3*Math.PI))+"\t perimeter = "+String.format("%.3f", (3*2*Math.PI)), circ.toString());
 
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Squre toString incorrect.", "Square\t ID = Square1\t area = 9.000\t perimeter = 12.000", sqr.toString());

	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		Shape a = new Circle("Circle1",3);
		Shape b = new Circle("Circle1",4);
		ShapePerimeterComparator com = new ShapePerimeterComparator();
		Assert.assertEquals("Incorrect perimeter comparision", -1, com.compare(a, b));
		Assert.assertEquals("Incorrect perimeter comparision", 1, com.compare(b, a));

		Shape c = new Circle("Circle1",3);
		Shape d = new Circle("Circle1",3);
		Assert.assertEquals("Incorrect perimeter comparision", 0, com.compare(c, d));
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		Shape a = new Circle("Circle1",3);
		Shape b = new Circle("Circle2",4);
		Assert.assertEquals("Incorrect natural comparision", -1,a.compareTo(b));
		Assert.assertEquals("Incorrect natural comparision", 1, b.compareTo(a));

		Shape c = new Circle("Circle3",3);
		Shape d = new Circle("Circle4",3);
		Assert.assertEquals("Incorrect natural comparision", 0, c.compareTo(d));
		Assert.assertEquals("Incorrect natural comparision", 0, d.compareTo(c));
		
		Shape e = new Rectangle("Rectangle1",4,4);
		Shape f = new Rectangle("Rectangle1",8,2);
		Assert.assertEquals("Incorrect natural comparision", -1, e.compareTo(f)); 
		Assert.assertEquals("Incorrect natural comparision", 1, f.compareTo(e)); 
		Shape g = new Rectangle("Rectangle1",3,4);
		Shape h = new Rectangle("Rectangle1",3,4);
		Assert.assertEquals("Incorrect natural comparision", 0, g.compareTo(h));    
		Assert.assertEquals("Incorrect natural comparision", 0, h.compareTo(g)); 

    }
}
