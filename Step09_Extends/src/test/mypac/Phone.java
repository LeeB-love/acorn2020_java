package test.mypac;

public class Phone extends Object{  //extends Object 는 생략가능
	
	public Phone() {
		System.out.println("Phone() 생성자 호출됨");
	}
	
	public void call() {
		System.out.println("전화를 걸어요");
	}

}
