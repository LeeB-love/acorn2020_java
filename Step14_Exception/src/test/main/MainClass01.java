package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력 : ");
		String inputNum = scan.nextLine();
		try {
			//입력한 숫자를 실제 숫자로 바꾼다.
			double num = Double.parseDouble(inputNum);
			double result = num + 100;
			//입력한 숫자에 100을 더한다.
			System.out.println("입력한 숫자 + 100 : "+result);
		}catch(NumberFormatException nfe) {
			System.out.println("숫자 형식에 맞게 입력하세요.");
			nfe.printStackTrace();  // error 문장이 출력된다.
		}//catch(){} 예외 타입이 또 있으면 catch를 연결해서 작성하면 된다.
		
		System.out.println("main 메소드가 종료됩니다.");
		//예외상황을 고려해야한다. 만약 인풋에 백을 써넣는다면? ==> 예외가 발생할 수 있는 곳에 try라는 블록을 묶어준다.
	}
}
