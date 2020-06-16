package test.mypac;
/*
 *  사용자 정의 Exception도 만들 수 있다.
 *  실행 시 발생하는 Exception은 RuntimeException 을 상속 받아서 만들면된다.
 */
public class SleepyException extends RuntimeException{
	//예외 메세지를 생성자의 인자로 전달받아서 
	public SleepyException(String msg) {
		super(msg);
	}
}
