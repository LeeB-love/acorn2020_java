package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * [컴퓨터와 가위바위보 하기]
		 * 가위(s) 바위(r) 보(p) :s
		 * 나 : 가위 vs 컴 : 보
		 * win~
		 */
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("종료하시려면 Q를 눌러주세요");
			String str1 = scan.nextLine();
			if(str1.equals("q")) {
				break;
			}
			
			System.out.println("원하는 패를 입력하시오(가위(s)/바위(r)/보(p))");
			

			String str = scan.nextLine();
			//나
			
			if(str.equals("s")) {
				System.out.println("나 : 가위");
			}else if(str.equals("r")) {
				System.out.println("나 : 바위");
			}else if(str.equals("p")) {
				System.out.println("나 : 보");
			}
			
			//컴퓨터
			Random ran = new Random();
			int num = ran.nextInt(3);
			
			if(num == 0) {
				System.out.println("컴퓨터 : 가위");
			}else if(num == 1) {
				System.out.println("컴퓨터 : 바위");
			}else {
				System.out.println("컴퓨터 : 보");
			}
			
			//승패결과출력
			if(str.equals("s") && num ==0) {
				System.out.println("비겼습니다.");
			}else if(str.equals("r") && num == 1) {
				System.out.println("비겼습니다.");
			}else if(str.equals("p") && num == 2) {
				System.out.println("비겼습니다.");
			}else if(str.equals("s") && num == 2) {
				System.out.println("이겼습니다.");
			}else if(str.equals("r") && num ==0) {
				System.out.println("이겼습니다.");
			}else if(str.equals("p") && num ==1) {
				System.out.println("이겼습니다.");
			}else {
				System.out.println("졌습니다. ㅠㅠ");
			}
		}
	}
}
