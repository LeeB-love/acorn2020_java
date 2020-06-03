package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("종료(q) 계속(Enter) : ");
			String str = scan.nextLine();
			if(str.equals("q")) {   //무한루프 탈출 조건
				break;
			}
			
			doGame();   //MainClass11 생략가능
			
		}
		System.out.println("main 메소드가 종료됩니다.");
		
	}
	
	public static void doGame() {
		Random ran = new Random();
		
		String[] items = {"cherry", "apple", "banana", "watermelon", "7"};
		Random ran1 = new Random();
		int[] points = {10,20,30,40,50,1000};
		
		int[] nums =new int[3];
		for(int i=0; i<3; i++) {
			int ranNum = ran1.nextInt(5);
			nums[i] = ranNum;
		}
		
		for(int i=0; i<nums.length; i++) {
			try {
				//실행의 흐름(스레드)을 1초 잡아놓기
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("|\t"+items[nums[i]]+"\t|");    //.print() 메소드를 이용해서 기행기호를 출력하지 않는다.
		}
		
		//개행 한 번 하기
		System.out.println();
		System.out.println();
		
//		System.out.println(items[nums[0]]+" | "+items[nums[1]]+" | "+items[nums[2]]);
		
		if(nums[0]==nums[1] && nums[1]==nums[2]) {
		System.out.println("축하합니다!"+points[nums[0]]+"점 입니다!");
		}else{
		System.out.println("0점입니다 ㅜㅜ");
		}
	}
}
