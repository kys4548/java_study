package study02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
	public static void main(String[] args) {
		String[] strArr = {"bbb", "aaa", "ccc"};
		List<String> strList = new ArrayList(Arrays.asList(strArr));
		int[] intArr = {5, 4, 3, 1, 2};
		
		Arrays.stream(strArr).sorted().forEach(System.out::println);
		Arrays.stream(strArr).forEach(System.out::println);
		System.out.println();
		
		List<String> sortedList = strList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList.toString());
		
		System.out.println(Arrays.stream(strArr).parallel().mapToInt(s -> s.length()).sum());
		System.out.println();
		
		Random random = new Random();
		random.doubles(5).forEach(System.out::println);
		System.out.println();
		
		IntStream.rangeClosed(1, 10).skip(3).limit(5).forEach(System.out::println);
		System.out.println();
		
		IntStream.of(1,2,2,3,3,3,4,5,5,6).distinct().filter(i -> i%2 == 0).;
	}
}
