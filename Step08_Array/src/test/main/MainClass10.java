package test.main;

import java.util.Random;

public class MainClass10 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		String[] items = {"cherry", "apple", "banana", "watermelon", "7"};
		Random ran1 = new Random();
		int[] points = {10,20,30,40,50,1000};
		
		int[] nums =new int[3];
		for(int i=0; i<3; i++) {
			int ranNum = ran1.nextInt(5);
			nums[i] = ranNum;
		}
		System.out.println(items[nums[0]]+" | "+items[nums[1]]+" | "+items[nums[2]]);
		
		if(nums[0]==nums[1] && nums[1]==nums[2]) {
		System.out.println("축하합니다!"+points[nums[0]]+"점 입니다!");
		}else{
		System.out.println("0점입니다 ㅜㅜ");
		}
	}	
}