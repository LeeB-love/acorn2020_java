package test.main;
/*
 *  6. 3항 연산자 테스트
 *  조건부로 둘 중에 하나를 대입해야할 때 사용한다.
 *  1이 true이면 콜론의 좌측이 대입, false 면 콜론의 우측에 있는것이 대입된다.
 */
public class MainClass06 {
	public static void main(String[] args) {
		boolean isWait=false;
		String result = isWait ? "기다려요" : "기다리지 않아요";
		//isWait 이 true 이면 "기다려요"가 대입되고 false면 "기다리지 않아요"가 대입된다.
		System.out.println(result);
		
		//위의 3항 연산자는 아래와 같이 if~else 문과 같은 로직이다.
		String result2=null;
		if(isWait) {
			result2="기다려요";
		}else {
			result2="기다리지 않아요";
		}
		System.out.println(result2);
	}
}











