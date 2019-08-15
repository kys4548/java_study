* Boxing 과 UnBoxing

Wrapper 클래스는 산술연산을 위해 정의된 클래스가 아니기 때문에, 이 클래스의 인스턴스에 저장된 값은 변경이 불가능하며, 값을 저장하는 새로운 객체의 생성 및 참조만 가능하다.

- Boxing							- AutoBoxing
Integer age = new Integer(30);		Integer obj = 61;
- Unboxing							- AutoUnBoxing
int age2 = age.intValue();			int num1 = obj;

요즘에는 Auto로 해줌

public static Wrapper valueOf(String s); 
//String을 해당 Wrapper type로 반환

public static primitive parseXxx(String s);
//String에서 기본형으로 반환

public String toString();
//Wrapper에서 String으로 반환

public static String toString(primitive p);
//기본형에서 String으로 변환


public static Wrapper valueOf(primitive p);
//기본형을 해당 Wrapper type로 반환 

xxxValue() method
//Wrapper에서 매칭되는 기본형으로 반환

int a = Integer.bitCount(n);
// 10진수 2진수로 변환