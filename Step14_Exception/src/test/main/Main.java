package test.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("나눌 수 입력 : ");
		String inputNum1 = scan.nextLine();
		System.out.println("나누어 지는 수 입력: ");
		String inputNum2 = scan.nextLine();
		
			double num1 = Double.parseDouble(inputNum1);
			double num2 = Double.parseDouble(inputNum2);
			
			double result = num1/num2;
			System.out.println(num2+" 를 "+num1+" 으로 나누면 "+result+" 입니다.");
		
		System.out.println("main 메소드가 정상 종료됩니다.");
	}
}