package study01;

import java.util.Arrays;
import java.util.Comparator;

public class Application {
	public static void main(String[] args) {
		Person[] arr = new Person[5];
		
		for(int i=0; i<5; i++) {
			arr[i] = new Person("kim" +(5-i), 10+i);
		}
		
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
			
		});
		System.out.println(Arrays.toString(arr));
		
	}
}
