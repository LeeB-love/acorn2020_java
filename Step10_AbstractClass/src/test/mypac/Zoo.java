package test.mypac;
//동물원 클래스
public class Zoo {
	
	//클래스안에 클래스 (내부클래스)
	public class Monkey{
		public Monkey say() {   //내부 클래스로 객체를 생성해서 리턴해주는 메소드
			System.out.println("안녕! 나는 원숭이야");
			return new Monkey();
		}
	}
	//내부클래스
	public class Tiger{
		public  void say() {
			System.out.println("안녕! 나는 호랭이야~");
		}
	}
	
	public Monkey getMonkey() { //내부 클래스로 객체를 생성해서 리턴해주는 메소드
		return new Monkey();
	}
	
	public Tiger getTiger() {
		return new Tiger();
	}
	
}
