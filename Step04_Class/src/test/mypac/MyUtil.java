package test.mypac;

public class MyUtil {
	//필드
	public static String version;    //static을 붙이면 static field, 안붙이면 none static field
	
	// 메소드
	public static void send() {  //static 을 붙이면 static method가 된다. 안붙이면 none static
		System.out.println("전송합니다.");
	}
}

// static이 붙은 것은 오직 하나임. 필드도 하나, 메소드도 하나 
// 하나만 있어도 되면 static 쓰고, 여러개 찍어내야하면 static 붙이지 말기
