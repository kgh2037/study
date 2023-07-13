package study05;

public class guide {

}
/*
{객체지향의 4대 요소}
1. 캡슐화(class 접근)
	- 접근지정자 : public > 전체 접근 가능 (Main method가 있는 class에만 선언)
				   protected > 타 패키지 클래스 접근 불가
				   접근지정자 생략 > 동일 package일 경우 상속까지만 접근 허용
				   private > 타 class 접근 불가 (입력 및 호출 불가)
				   ㄴ> 직접 호출이 불가능함으로 전달 method 선언 후 매개변수 설정 필요 

2. 다형성(method 접근)
	- 오버로딩(overloading) : class 내에서 동일 method명 선언 > 매개변수의 종류 및 갯수 상이해야 가능
	- 오버라이딩(overriding) :  상위 class의 method를 상속하여 동일명으로 재정의

3. 상속(class 개념)
	- extends 사용하여 상속 관계 설정
	ex ) 상위 class 명 : example
		 하위 class 명 : i(하위 class 명) extends class example
4. 추상화(명세처리)
	- 추상class  -> 생성 abstract name { }
				 -> 구현 extends name 상속 후 구현 (반드시 구현해야 작동)
				 
	- 인터페이스 -> 생성 interface name { }
				 ->	구현 implements name 상속 후 구현






*/