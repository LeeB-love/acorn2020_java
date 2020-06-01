package test.mypac;

public class Messenger {
	//String type 을 인자로 전달받는 static 메소드
	
	public static void sendMessage(String msg) {
		System.out.println(msg + " 를 전송합니다.");
	}
	public static  String getMessage() {
		return "hello";
	}
	public static void useCar(Car c) {
		c.drive();
	}
}
