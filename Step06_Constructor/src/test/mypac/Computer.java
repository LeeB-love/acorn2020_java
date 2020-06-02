package test.mypac;

public class Computer {
	//필드
	public Cpu cpu;
	// 기본 생성자 (인자로 아무것도 전달받지 않는 생성자)
	public Computer() {
		System.out.println("기본 생성자가 호출되었습니다.");
	}
	// Cpu 타입 cpu를 전달하는 생성자 (생성자 모양이 다르면 여러개 전달 가능~)
	public Computer(Cpu cpu) {
		this.cpu = cpu;
	}
	//메소드
	public void doGame() {
		if(this.cpu==null) {
			System.out.println("Cpu가 없어서 컴퓨터가 동작을 안해요");
			return;
		}
		System.out.println("컴퓨터로 게임을 해요");
	}
}
