package test.main;

import java.util.Random;

/*  1. 
 *	cherry, apple, banana, melon, 7
 *	5개의 문자열 중에서 하나가 랜덤하게 출력되게 해보세요.
 *
 */
public class MainClass08 {
	public static void main(String[] args) {
		
		Random ran = new Random();
		
		String[] items = {"cherry", "apple", "banana", "melon", "7"};
		
		
		String[] str = new String[3];
		
		for(int i=0; i<3; i++) {
			int ranNum = ran.nextInt(items.length);
			str[i] = items[ranNum];
		}
		System.out.println(str[0]+"|"+str[1]+"|"+str[2]);

	}
}

