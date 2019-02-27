
public class Square extends Rectangle{
	/**
	 * Redundant constructor for a square
	 * 
	 * @param id	ID of the shape
	 * @param height	Height of the square
	 * @param width		Width of the square. If width != height, square will not form properly, so use of this constructor is discouraged.
	 */
	
	public Square(String id, double height, double width) {
		super(id, height, width);

	}
	/**
	 * Constructor for the square
	 * @param id		ID of the shape
	 * @param size		A side length of the square
	 */
	public Square(String id, double size) {
		super(id, size, size);

	}
	/**
	 * Returns the shape type Square.
	 */
	public String getShapeType() {
		return "Square";
	}
	

}
