
public class Square extends Rectangle{
	public Square(String id, double height, double width) {
		super(id, height, width);
		sideLengths.add(height);
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(width);


	}
	public Square(String id, double size) {
		super(id, size, size);
		sideLengths.add(size);
		sideLengths.add(size);
		sideLengths.add(size);
		sideLengths.add(size);

	}
	public String getShapeType() {
		return "Square";
	}
	

}
