package test.main;
/*
 *  [기본 data type 의 참조 data type]
 *   byte    : Byte
 *   short   : Short
 *   int     : Integer
 *   long    : Long
 *   
 *   float   : Float
 *   double  : Double
 *   
 *   char    : Character
 *   boolean : Boolean
 */
public class MainClass01 {
	public static void main(String[] args) {
		int num1 = 10;  //객체가 아니기 때문에 num1. 해도 아무것도 안나옴 
		Integer num2 = 10;
		
		//참조 데이터 type이지만 기본 데이터 type 처럼 사용할 수 있다. (기능만 더 들어있음)
		int result1 = num2+1;
		int result2 = num1+num2;
		Integer result3 = num1+num2;
		
		// 숫자를 문자로 바꾸기 10 => "10"
		String strNum = num2.toString();
		
		//문자를 숫자로 바꾸기
		String strNum2 = "999";
		int result4 = Integer.parseInt(strNum2);   // 정수로 바꿔준다.
		
		
	}
}


/*
*
* 	int num1 = 10; 하면 stack 영역에 num1이라는 지역변수가 만들어지고 그 안에 10이 저장됨
*
*	Integer num2 = 10; 
*	하면 기능과 저장소를 가지고있는 Integer type 객체가 만들어진다 (new하지 않아도 자동으로 만들어지는 객체)
*	그리고 객체가 기본데이터 타입(value 10)을 둘러싸고있다. 나중에 배열할 때 사용될 것.  
*/











