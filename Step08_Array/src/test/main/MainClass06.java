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
		
		/*
		 * 2. Random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내어 배열에 저장한다.
		 * 모두 다 저장이 되면 for 문을 이용해서 배열에 저장된 모든 로또 번호를 콘솔창에 순서대로 출력하는 코드를 작성해보세요.
		 */
		
		
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
		
		
		Random ran = new Random();
		int[] lotto = new int[6];
		
		for(int i=0; i<6; i++) {
			int lottoNum = ran.nextInt(45)+1;
			lotto[i] = lottoNum;
			
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
