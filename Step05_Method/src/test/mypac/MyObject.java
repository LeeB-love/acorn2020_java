package test.mypac;

/*
 * 	[메소드를 만들 때 고려해야 하는 것]
 * 	
 * 	1. 접근 지정자 (public or default 등)
 * 	2. 리턴 type  (리턴 없으면 void)
 * 	3. 메소드명 (소문자로 시작)
 * 	4. 메소드에 전달하는 인자(매개변수)의 개수와 데이터 type
 */

public class MyObject {
	/*
	 *  접근 지정자 : public == 이 메소드는 어디에서든 접근 가능하다.
	 *  void : 이 메소드는 어떠한 값도 리턴하지 않는다.
	 *  walk : 메소드 명
	 *  walk() : 이 메소드는 어떤 값도 전달받지 않는다.
	 *  
	 */
	public void walk() {
		System.out.println("걸음을 걸어요~");
	}
	
	//int type을 리턴해주는 메소드
	public int getNumber() {
		int myNum = 10;
		// int type을 리턴해주어야 문법이 성립한다.
		return myNum;
	}
	
	//String type을 리턴해주는 메소드
	public String getGreeting() {
		String greet = "안녕하세요!";
		return greet;
	}
	
	// Car type를 리턴해주는 메소드
	public Car getCar() {
		Car c1 = new Car();
		return c1;
	}
	
	public void setNum(int num) {
		System.out.println("num : "+num);
	}
	//String type을 메소드의 인자(지역변수임)로 전달받는 메소드
	public void setName(String name) {
		System.out.println("name : "+name);
	}
	//Car type을 메소드의 인자로 전달받는 메소드\
	public void useCar(Car car) {
		car.drive();
	}
	
	//String type과 Car type을 메소드의 인자로 전달받는 메소드
	public void useSome(String name, Car car) {
		System.out.println("name : "+name);
		car.drive();
	}
	
	//Radio type과 Speaker type을 전달받는 메소드
	public void doSome(Radio r, Speaker s) {
		System.out.println("doSome() 메소드가 호출되었습니다.");
	}
}











