
public class Square extends Rectangle{
	public Square(String id, double height, double width) {
		super(id, height, width);
	}
	public Square(String id, double size) {
		super(id, size, size);
	}
	public String getShapeType() {
		return "Square";
	}
	

}
