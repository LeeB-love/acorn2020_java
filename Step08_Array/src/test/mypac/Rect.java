package test.mypac;

public class Rect {
	//필드
	public int width;
	public int height;
	//생성자
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	//메소드
	public int getArea() {
		return width*height;
	}
}
