package test.mypac;
/*
 * Generic type (포괄, 총칭) : 원하는 타입으로 유동적으로 바꿀 수 있다.
 * Class name 오른쪽에 <> 쓰고 안에는 포괄타입 이름 ㄱㄱ
 * class 클래스명<Generic type>
 * 	- 클래스를 정의할 때 Generic type을 지정해서 특정 type을 동적으로 지정할 수 있다.
 * 	- <B, B2, B3...> 등 여러개 지정 가능하다. 보통 T를 많이 쓴다. (type의 t)
 * 	- Generic 지적을 안하면 Object 로 지정된다. (모든 객체의 부모타입으로 결정됨)
 */
public class FruitBox<B> {
	//필드
	private B item;
	//메소드
	public void push(B item) {
		this.item = item;
	}
	public B pull() {
		return item;
	}
}
