package test.mypac;

public class Member {
	
	//non static 필드 정의하기
	public int number;
	
	public String name;
	
	public String addr;
	
	//non static 메소드 정의
	public void showInfo() {
		//설계단계에서 this = 내가 객체가 되었을 때 나의 참조값, 혼돈의 소지가 없다면 생략이 가능하다.
		System.out.println(this.number+"|"+this.name+"|"+this.addr);
	}
}
