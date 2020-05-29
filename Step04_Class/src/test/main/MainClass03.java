package test.main;

import test.mypac.Car;
import test.mypac.MyUtil;
import test.mypac.YourUtil;

public class MainClass03 {
	public static void main(String[] args) {
		
		//Car 객체를 생성하기
		new Car().drive();         
		
		//Car 객체를 생성해서 참조값을 car1이라는 지역변수에 담기
		Car car1 = new Car();      
		car1.drive();
		
		//Car 객체를 생성해서 참조값을 car2라는 지역변수에 담기
		Car car2 = new Car();      
		car2.drive();
		
		//MyUtil 클래스의 send() 라는 static 메소드 호출하기
		MyUtil.send();             
		
		//YourUtil 클래스의 up() 이라는 static 메소드 호출하기
		YourUtil.up();               
	}
}


// nonstatic = 객체를 만들고 객체의 참조값을 얻어서 메소드 호출
// staitc = 그냥 클래스명에 . 찍어서 메소드 사용


/* 1.
 * new Car()하면 heap 영역에 객체와 참조값 20을 생성하고 new Car()자리에 참조값 20으로 변함
 * .drive로 참조값 20번 사물함에 저장되어있는 객체 중 메소드 호출   ---> 변수에 저장하지 않고 객체를 호출하고 끝. 일회용으로 볼 수 있음.
 * 
 * 2.
 * new Car()하면 heap 영역에 객체와 참조값 22를 생성하고 new Car(); 자리가 참조값 22로 변함
 * Car type에 이름이 car1이라는 지역변수에 22번 참조값 저장
 * car1 변수 에 저장되어있는 22번 키를 불러와서 그안에 저장되어있는 객체 중 메소드 drive를 호출  
 * 
 * 3.
 * new Car()하면 heap 영역에 객체와 참조값 23을 생성하고 new Car(); 자리가 참조값 23으로 변함
 * Car type에 이름이 car2라는 지역변수에 23번 참조값 저장
 * car2 변수에 저장되어있는 23번 키를 불러와서 그 안에 저장되어있는 객체 중 메소드 drive를 호출
 * 
 * 4. 
 * MyUtil라는 이름의 Class를 불러내면 static영역 (Class 명으로 서로를 구분한다.)에 MyUtil 클래스 전체가 통째로 올라간다. 
 * MyUtil 클래스 의(.) send라는 메소드 호출();
 * 
 * 5.
 * YourUtil 호출 => static 영역에 YourUtil 클래스 전체가 통째로 올라간다.
 * YourUtil 클래스 의(.) up이라는 메소드 호출();
 * 
 * 필드영역의 변수는 선언만 하면 만들어지고
 * 지역변수는 선언만 하면 만들어지지않는다. 초기값 null이나 0이 들어가있어야함.
 * 지역변수는 메소드 안에서 만들어지는게 지역변수(메소드가 실행되고 있을 때 stack에 존재하고 메소드가 끝나면 사라짐)
 * 
 * heap 영역에 만들어진 객체 중에 더 이상 사용하지 않는 객체들이 존재한다. -> 쓰레기라고 부름 ㅜ ㅜ
 * 자바에서는 쓰레기를 신경쓰지 않아도 자바가 알아서 정리한다.
 * 
 * static 영역에 한 번 올라가면 프로세스가 종료될 때 까지 해제할 수 없다.
 * 따라서 너무 많은 클래스를 static에 올리는건 과부화를 불러올 수 있다.
 */











