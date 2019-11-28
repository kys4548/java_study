for(Strng name : participant){
	hm.put(name,hm.getordefault(name,0)+1);
}
//  participant 배열에서 스트링을 하나씩 읽어와 name에 저장하여 반복문 진행
//	getordefault(name,0) : hm HashMap에서 name Key값을 입력하여 그 Key 값에 따른 
//	value값이 존재할경우 value값 반환 없을경우 0(default값) 반환 



new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
// 	무슨 코드냐 쩐다...
// 	ex) n=5라면
// 	1.null이 3개 들어간 문자열배열을 만든다.
//	2. 만든 문자열 배열에서 null 대신 "수박"을 넣는다.
//	0~n번까지만 나오게 짜른다. 홀수일경우 맨 뒤 "박"이 짤리고 짝수일경우 그대로 유지

for (int i = 0; i < n; i++)
      result += i % 2 == 0 ? "수" : "박";
 return result;
 // 음 이것도 코드 멋있군

 -----------------------------------------------------------------------
Arrays.asList(seoul).indexOf("Kim");
//	 asList : seoul이란 이름을 가진 String 배열을 arrayList로 변환
//	 indexOf : arrayList로 변환하였기 때문에 값에 따른 인덱스값 반환 가능

Arrays.sort(array); 			Arrays.fill(array,1);  
//	 array배열을 정렬해준다.  	배열안의값을 모두 1로 초기화하여 준다.
Arrays.sort(array,Collections.reverseOrder());
// 내림차순으로 정렬

a2 = Arrays.copyOfRange(a, from, to);	배열 부분의 새로운 얕은 복사본.

---------------------------------------------------------------------------

Integer.parseInt() /* 문자열 정수변환 */ 	Integer.toString() /* 정수 문자열변환 */
//	parseInt와 valueOf 차이 
//	1. parseInt는 int반환 valueOf는 Integer 반환
//	2. parseInt는 "+","-"인식, 음수 지원, Integer을 불가

int[] arr = new int[]{1}; //원소 1 하나인 배열 생성
------------------------------------------------------------------------

String에 사용할수 있는 Operation
// 	s.length(), s.charAt(3), s.indexOf("a"), 
// 	s.substring(3) 뒤부터 짜름 or substring(0,3) 사이값 가져오기
// s.toUpperCase() s.toLowerCase() 전체 대문자 소문자 바꾸기 
// s.replace(" ","");  모든공백제거 s.trim(); 앞뒤 공백제거
// s.toCharArray()

String[] array = str.split(" ");
//" " 로 문자열 분리  str.split("\\s")와 같다.
//공백이 여러개 연속되어서 나올때 구분 못해주는 문제 발생  
ex) "  a    b   " 
맨 앞에 공백 2 사이에 공백 4 맨끝에 공백 3일 때,
length = 2 + a + 3 + b가 되어버린다. 
뒤에 공백이 아예 사라짐 

뒤에 공백을 사라지지 않음, 맨마지막 문자로 끝날경우 대비 null까지 해주는건가 
str.split(" ",-1); 
length =  2 + a + 3+ b +3

공백이 여러개 있을때에도 구분하고 싶을때 
=> str.split("\\s+"); 으로 해주면 된다.


문자열이 비어있지 않은가 확인하는 방법
if(str != null && !str.isEmpty())


word.substring((word.length()-1) / 2, word.length()/2 + 1); 
//문자열에서 가운데 글자 가져오는 코드   
//와 이걸 한줄로 짜버리네;; 

기본적으로 String은 값이 변경 불가하다.
그 값을 바꾸고 싶을때나 메모리 측면에서 문자열끼리 더할때 다른 객체 사용

ex) answer = new StringBuilder(answer).reverse().toString();
//String이 가진 문자열을 반대로 뒤집어 반환하는 코드
StringBuilder 클래스가 제공하는 메소드 목록

length() 
capacity()
append() //뒤에 문자열 붙이기
insert() //몇번째 index에 문자 삽입 
delete() //(, ) 어디부터 어디까지 index삭제
replace() // (, ,)어디부터 어디까지 문자열을 새로운 문자열로 대체 
reverse() //문자열을 뒤집는다.
toString() //문자열을 반환

-------------------------------------------------------------------
char 에서 String 변환방법 Sring s = Character.toString(str.charAt(i)); 
char[] arr에서 Sring으로 변환방법 String.valueOf(arr);

String str에서 char[]으로 변환방법 str.toCharArray();

숫자 '3' char에서 int 변환방법 s.charAt(i)- '0';


ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
배열에서 list변환방법 

String[] array = new String[arrayList.size()];
int size=0;
for(String temp : arrayList){
  array[size++] = temp;
}
list에서 배열로 변환방법 
--------------------------------------------------------------------




소수 판별법
어떤 수 n이 소수인지 알아보기 위해서는 1과 n 사이의 모든 자연수로 나눠보면 됩니다. 
중 하나로라도 나뉘어 떨어진다면 1이나 자기 자신이 아닌 수를 인수로 갖는다는 소리니
소수가 아니겠죠?

하지만 2 … n-1의 모든 수를 확인할 필요가 없습니다. n−−√까지만 확인하면 돼요. 
그 이유는 n이 소수가 아닐 경우 1이나 n이 아닌 어떤 a, b에 대해, 
n=a×b의 관계를 가질텐데, 우리가 이 수가 소수가 아님을 증명하기 위해서는 
n이 a나 b로 나뉨을 보이면 됩니다. 
그런데 a나 b 중 크지 않은 쪽은 최대 n−−√의 값을 가지기 때문에,
(한 수가 (√n) 이상의 값을 가지려면 다른 수는 그 이하여야만 
두 수의 곱이 n이 될 수 있습니다.) n−−√ 이하의 자연수 중 나뉘어 떨어지는 
수가 없다면 소수인거죠.

for(int i=1; i<=Math.sqrt(n) i++){

} 어떤 수의 약수를 구할때도 유용하다.



Character.isUpperCase(char)를 사용 대문자인지 구별하고
Character.isLowerCase(char)를 사용 소문자인지 구별
Character.isDigit(char) 를 사용하여 숫자인지 구별


-----------------------------------------------------------------------
스트림에 대한 내용은 크게 세 가지로 나눌 수 있습니다.

1.생성하기 : 스트림 인스턴스 생성.
		
	배열 스트림
	String[] arr = new String[]{"a", "b", "c"};
	Stream<String> stream = Arrays.stream(arr);

	컬렉션 스트림
	List<String> list = Arrays.asList("a", "b", "c");
	Stream<String> stream = list.stream();

	Stream<String> generatedStream =Stream.generate(() -> "gen").limit(5);
	//5개의 “gen” 이 들어간 스트림이 생성됩니다.

	Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5);
	//// [30, 32, 34, 36, 38]

	IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
	LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
	Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();

	DoubleStream doubles = new Random().doubles(3); // 난수 3개 생성

	IntStream charsStream ="Stream".chars(); 
	// [83, 116, 114, 101, 97, 109]


	Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
	Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
	Stream<String> concat = Stream.concat(stream1, stream2);
	// [Java, Scala, Groovy, Python, Go, Swift]


	2.가공하기 : 필터링(filtering) 및 맵핑(mapping) 등 
		원하는 결과를 만들어가는 중간 작업(intermediate operations).

	List<String> names = Arrays.asList("Eric", "Elena", "Java");

	filter : 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업
	Stream<String> stream = names.stream().filter(name -> name.contains("a"));
	// [Elena, Java]

	맵(map) : 스트림 내 요소들을 하나씩 특정 값으로 변환
	Stream<String> stream = names.stream().map(String::toUpperCase);
	// [ERIC, ELENA, JAVA]

	Stream<Integer> stream = productList.stream().map(Product::getAmount);
	// [23, 14, 13, 23, 13]  각 ‘상품’을 ‘상품의 수량’으로 맵핑

	sorted : 정렬
	IntStream.of(14, 11, 20, 39, 23).sorted().boxed().collect(Collectors.toList());
	// [11, 14, 20, 23, 39]
	
	List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
	lang.stream().sorted().collect(Collectors.toList());
	// [Go, Groovy, Java, Python, Scala, Swift]
	lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	// [Swift, Scala, Python, Java, Groovy, Go]
	lang.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList());
	// [Groovy, Python, Scala, Swift, Java, Go]


	3.결과 만들기 : 최종적으로 결과를 만들어내는 작업(terminal operations).

	long count = IntStream.of(1, 3, 5, 7, 9).count();
	long sum = LongStream.of(1, 3, 5, 7, 9).sum();
	OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
	OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();

	List<String> collectorCollection =productList.stream()
 	.map(Product::getName).collect(Collectors.toList());
	// [potatoes, orange, lemon, bread, sugar]

 	String listToString = productList.stream().map(Product::getName)
  	.collect(Collectors.joining());
	// potatoesorangelemonbreadsugar

	.collect(Collectors.joining(", ", "<", ">"));
	// <potatoes, orange, lemon, bread, sugar>
	

	Double averageAmount = productList.stream()
  	.collect(Collectors.averagingInt(Product::getAmount));
	// 17.2

	Integer summingAmount = productList.stream()
	  .collect(Collectors.summingInt(Product::getAmount));
	// 86

	Integer summingAmount = productList.stream().mapToInt(Product::getAmount)
  	.sum(); // 86



	 List<String> names = Arrays.asList("Eric", "Elena", "Java");

	boolean anyMatch = names.stream().anyMatch(name -> name.contains("a"));
	boolean allMatch = names.stream().allMatch(name -> name.length() > 3);
	boolean noneMatch = names.stream().noneMatch(name -> name.endsWith("s"));

--------------------------------------------------------------------------
int[] 에서 최소값 찾기
int min = Arrays.stream(arr).sorted().findFirst().getAsInt();
int min = Arrays.stream(arr).min().getAsInt();

스트림으로 list만들기
List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

list 스트림을 통해 배열 만들기 
return list.stream().mapToInt(i->i).toArray();