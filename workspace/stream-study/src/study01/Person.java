package study01;

class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person p) {
		return name.compareTo(p.getName());
	}
}
