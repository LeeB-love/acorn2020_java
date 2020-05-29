package test.mypac;

//사각형이 정보를 담을 수 있는 Rect 클래스
public class Rect {
	//non static 필드
	public int width;  //폭
	public int height;  //높이
	
	//사각형의 면적을 리턴해주는 non static 메소드
	public int getArea() {    // 이 메소드가 리턴해주는 값의 타입이 int라는 뜻
		int area = this.width * this.height;
		return area;
	}
}

//void : 텅빈. 아무것도 리턴해주지 않는다는 뜻.
