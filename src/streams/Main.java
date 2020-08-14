package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String[] myArray = new String[] { "bob", "alice", "paul", "ellie" };
		mapArray(myArray);
		mapList();
		filterArray(myArray);
		filterList();
		reduceArray();
		reduceNumArray();
	}

	public static void mapArray(String[] myArray) {
		Stream<String> myNewStream = Arrays.stream(myArray)
				.map(s -> s.contains("a") ? s.toUpperCase() : s.toLowerCase());
		myNewStream.forEach(s -> System.out.println(s));

		// String[] myNewArray = myNewStream.toArray(String[]::new);
	}

	public static void mapList() {
		List<HashMap<String, Object>> listEmployee = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> employee = new HashMap<String, Object>();
		employee.put("name", "koko");
		employee.put("age", 24);
		listEmployee.add(employee);

		employee = new HashMap<String, Object>();
		employee.put("name", "jahe");
		employee.put("age", 31);
		listEmployee.add(employee);

		employee = new HashMap<String, Object>();
		employee.put("name", "santi");
		employee.put("age", 44);
		listEmployee.add(employee);

		listEmployee.stream().map((e) -> {
			HashMap<String, Object> a = new HashMap<String, Object>(e);
			a.put("grade", 10);
			return a;
		}).collect(Collectors.toList()); // Collect stream and convert to List

	}

	public static void filterArray(String[] myArray) {
		String[] myNewArray = Arrays.stream(myArray).filter(s -> s.length() > 4).toArray(String[]::new);

		System.out.println(myNewArray);
	}

	public static void filterList() {
		List<String> studentName = Arrays.asList("hector", "hana", "stone");

		List<String> result = studentName.stream() // Convert list to stream
				.filter(name -> !"hana".equals(name)) // remove "hana" from list
				.collect(Collectors.toList()); // collect the output and convert Stream to List

		// print using method reference
		result.forEach(System.out::println);
	}

	public static void reduceArray() {
		String[] myArray = { "this", "is", "a", "sentence" };
		String result = Arrays.stream(myArray).reduce("", (a, b) -> {
			if (a.equals("")) {
				return b;
			} else {
				return a + " " + b;
			}
		});

		System.out.println(result);
	}

	public static void reduceNumArray() {
		int numArray[] = { 1, 5, 8 };
		int sum = Arrays.stream(numArray).sum();
		double avg = Arrays.stream(numArray).average().getAsDouble();
		long count = Arrays.stream(numArray).count();

		System.out.println(sum + " " + avg + " " + count);
	}

}
