package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 기본 데이터 타입 double
		double num1=10.1;
		// 참조 데이터 타입 Double
		Double num2 = 10.2;
		
		// 참조 데이터 타임 Double 이지만 마치 기본 데이터 타입과 같이 사용할 수 있다.
		double result1 = num2 + 10;
		double result2 = num1 + num2;
		Double result3 = num1 + num2;
		
		// 숫자를 문자열로 바꾸기 10.1=> "10.1"
		String strNum = num2.toString();
		
		//문자열을 숫자(double)로 바꾸기
		String strNum2 = "22.3";
		double result4 = Double.parseDouble(strNum2);
		
	}
}

//toString()과 Double.parseDouble, Integer.parseInt 는 정말 많이 사용한다.
