package test.main;

public class MainClass05 {
	//필드
	public String myName = "이봉하";
	public static String yourName = "원숭이";
	
	public static void main(String[] args) {
		//static 메소드 안에서 this는 의미도 없고 사용불가
		//System.out.println(this.myName);
		
		//myName이라는 필드는 non static이므로 클래스명. 으로 접근불가
		//System.out.println(MainClass05.myName);
		
		//yourName은 static 필드이므로 클래스명. 으로 접근가능
		System.out.println(MainClass05.yourName); 
		
		//같은 클래스 내부의 필드를 참조하면 클래스명 생략가능
		System.out.println(yourName); 
		//System.out.println(this.yourName);
		
		//myName은 non static 필드임으로 참조값으로 접근가능
		System.out.println(new MainClass05().myName);
	}
}
