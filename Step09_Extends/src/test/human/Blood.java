package test.human;

//혈액형 정보를 저장학 객체를 생성할 클래스
public class Blood {
	//필드
	private String rh;
	private String type;
	
	//생성자
	public Blood(String rh, String type) {
		this.rh = rh;
		this.type = type;
	}//생성자를 통해 필드값을 받아오면, 변경불가
	
	//필드에 저장된 rh를 리턴해주는 getter 메소드
	public String getRh() {
		return rh;
	}
	//필드에 저장된 type을 리턴해주는 getter 메소드
	public String getType() {
		return type;
	}
	/*getter method : 외부에 private로 지정되어있는 필드값을 공개하는 것(변경은 불가하지만 확인할 수는 있다.)
	 * 필드를 선언하고 나서 get을 타이핑 후 ctrl+space 키를 누르면 이클립스가 getter 메소드를 자동으로 만들어 줄 준비를 한다.
	 * private field(저장소 만들기) + Constructor(값 받아와서 저장소에 저장하기 기능) + getter method(값 확인하기 기능) => 한 세트로 많이 사용
	 */
}
