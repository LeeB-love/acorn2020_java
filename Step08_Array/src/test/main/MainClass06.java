package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 문자열을 5번 입력 받는다.
		 * 입력받은 문자열을 차례대로 배열에 저장되어야한다.
		 * 모두 다 입력받은 후 for 문을 이용해서 배열에 저장된 모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해보세요. 
		 */
		
		//Scanner 객체를 생성해서 참조값을 지역 변수에 담기
		//java.lang 패키지 안에 있는 객체들은 import 없이 사용할 수 있다. - System, String, Integer, Short... 등 
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열을 5번 입력하시오");

		String[] msg = new String[5];
		for(int i=0; i<5; i++) {
			String str = scan.nextLine();
			msg[i] = str;
		}
		for(int i=0; i<msg.length; i++) {
			System.out.println(msg[i]);
		}
		
		
		/*
		 * 2. Random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내어 배열에 저장한다.
		 * 모두 다 저장이 되면 for 문을 이용해서 배열에 저장된 모든 로또 번호를 콘솔창에 순서대로 출력하는 코드를 작성해보세요.
		 */
		
		Random ran = new Random();
		int[] lotto = new int[6];
		
		for(int i=0; i<6; i++) {
			int lottoNum = ran.nextInt(45)+1;
			lotto[i] = lottoNum;
			
			//중복 뽑기 없애기
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
				}
			}
		}
		for(int i=0; i<lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		

		
	}
}


/*
 * public class System 안에 
 * 뭔가를 입력받을 때 : public static final InputStream in;
 * 뭔가를 출력할 때 : public static final PrigntStream out;
 * 
 * InputStream
 * PrintStream
 * Scanner
 * String[]
 * String
 */


