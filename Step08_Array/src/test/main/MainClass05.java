package test.main;

import test.mypac.Rect;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Rect 객체를 담을 수 있는 방 3개짜리 배열객체를 생성해서 참조값을 rects라는 이름의 지역변수에 담아보세요.
		//2. 배열에 Rect 객체 3개를 순서대로 담아보세요.
		//3. 반복문 for문을 이용해서 각각 사각형의 면적을 콘솔창에 출력해보세요.
		
		Rect[] rects = new Rect[3];
			
		rects[0]= new Rect(2,3);
		rects[1]= new Rect(32,4);
		rects[2]= new Rect(5,7);
		
		for(int i=0; i<rects.length; i++) {
			int area = rects[i].getArea();
			System.out.println(area);
		}
		
	}
}
