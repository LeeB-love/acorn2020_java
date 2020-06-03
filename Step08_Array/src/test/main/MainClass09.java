package test.main;

import java.util.Random;

/*
 *  2. 5개의 문자열 중에서 3개가 한줄에 한번에 램점하게 출력되게 해 보세요.
 *	예) cherry | apple | cherry
 *		7 | apple | melon
 *		7 | 7 | 7  등  
 */
public class MainClass09 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		String[] items = {"cherry", "apple", "banana", "melon", "7"};
		Random ran1 = new Random();
		
		int[] nums =new int[3];
		for(int i=0; i<3; i++) {
			int ranNum = ran1.nextInt(5);
			nums[i] = ranNum;
		}
		System.out.println(items[nums[0]]+"|"+items[nums[1]]+"|"+items[nums[2]]);
		}
	}

