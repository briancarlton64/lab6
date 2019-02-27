
public class Rectangle extends Polygon {
	//Fields describing the properties of the rectangle
	private double height;
	private double width;
	//Constructs a rectangle with an id, a height, and a width.
	public Rectangle(String id, double height, double width) {
		//Pass the id to the super constructor
		super(id);
		//Set the fields to the appropriate values
		this.height = height;
		this.width = width;
		//Add the lengths of the sides to the sideLengths arraylist. Add them twice as the sides are duplicated in a rectangle.
		sideLengths.add(height);
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(width);


	}
	//Returns the area of the rectangle.
	@Override
	public double getArea() {
		return height*width;
	}
	// Returns Rectangle as the shape type.
	@Override
	public String getShapeType() {
		return "Rectangle";
	}
	

}
