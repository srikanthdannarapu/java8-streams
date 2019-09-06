package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeComparator {

	public static void main(String[] args) {
		List<Employee> employees = getEmployeeList();
		employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).limit(3).map(Employee::getName)
				.forEach(System.out::println);
		System.out.println("================");
		employees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).map(Employee::getName)
				.forEach(System.out::println);
		System.out.println("================");
		employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				.forEach((dep, num) -> System.out.println(dep + "::" + num));
		Map<String, Long> departmentWiseEmp = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("================");
		employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).filter(e -> e.isActive())
				.limit(3).map(Employee::getName).forEach(System.out::println);
		System.out.println("================");
		String commaSeperatedEmps = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
		System.out.println(commaSeperatedEmps);
		System.out.println("================");
		Map<Integer, Long> ageWiseEmps = employees.stream().parallel()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
		ageWiseEmps.forEach((k,v) -> System.out.println(k + ":" + v));

	}

	private static List<Employee> getEmployeeList() {

		return Arrays.asList(new Employee("Raja", 12, "Java", true), new Employee("Maza", 27, "React js", true),
				new Employee("Tez", 32, "Java", false), new Employee("Neil", 12, "Filenet", true),
				new Employee("Kaza", 27, "Datacap", true), new Employee("Soka", 74, "Datacap", false),
				new Employee("Paka", 65, "Java", true));
	}

}
