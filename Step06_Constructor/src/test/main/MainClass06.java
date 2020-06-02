package test.main;

import javax.swing.JFrame;

public class MainClass06 {
	public static void main(String[] args) {
		JFrame f = new JFrame("김구라");   //JFrame : GUI 생성해주는 객체. 창프레임 만들려면 사용해야한다.
		f.setTitle("죽어라 이 악마야"); // 창 제목 정하기
		f.setBounds(100, 100, 500, 500);   // 창크기(x좌표, Y좌표, 폭, 높이)
		f.setVisible(true);
		//창 닫았을 때 프로세스도 자동으로 종료되도록 한다.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE : 상수 3과 같다. 3 써도 같은 기능을 하나, 프로그래밍의 의미가 없어서 저렇게 쓴 것
		//JFrame.EXIT_ON_CLOSE = public static final int EXIT_ON_CLOSE; (static final - 절대 불변 상수) 상수를 객체로 만들어 의미를 부여한 것.
		
	}
}
