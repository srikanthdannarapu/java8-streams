package java8.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamDemo {
	
	public static void main(String[] args) {
		int[] numbers = {30, 25,30, 23, 25, 47, 11, 30, 11, 98};
		int min = IntStream.of(numbers).min().getAsInt();
		System.out.println("min: "+ min);//11
		 IntStream.of(numbers).min().ifPresent(System.out::println);
		 IntStream.of(numbers).max().ifPresent(System.out::println); //98
		 IntStream.of(numbers).average().ifPresent(System.out::println); // 33.333333333333336
		 int sum = IntStream.of(numbers).sum();
		 System.out.println("Sum::"+sum);
		 long count = IntStream.of(numbers).count();
		 System.out.println(count); //9
		 
		 IntSummaryStatistics statics = IntStream.of(numbers).summaryStatistics();
		 statics.getMin();
		 statics.getAverage();
		 statics.getAverage();
		 statics.getCount();
		 statics.getSum();
		 statics.getMax();
		 
		 IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);
		 IntStream.of(numbers).distinct().sorted().limit(3).sum();
		 IntStream.of(numbers).distinct().sorted().limit(3).summaryStatistics();
		 System.out.println("============");
		 IntStream.range(10, 15).forEach(System.out::println); // 10 to 14
		 System.out.println("============");
		 IntStream.rangeClosed(10, 15).forEach(System.out::println); //10 to 15
		 
		 IntSupplier supplier =  new IntSupplier() {
			 @Override
			public int getAsInt() {
				return (int) Math.random() * 10; 
			 }
		 };
		 supplier = () -> (int) Math.random() * 10;
		// IntStream.generate(() -> (int) Math.random() * 10).forEach(System.out::println);
		 
		 IntStream.of(numbers).skip(3);
		 System.out.println("============");
		 IntStream.of(numbers).distinct().filter(x -> x % 2 == 0).forEach(System.out::println);
		 System.out.println("============");
		 IntStream.of(numbers).map(x -> x * 2).forEach(System.out::println);
		 List<Integer> list = IntStream.of(numbers).boxed().collect(Collectors.toList());
		 System.out.println("============");
		 list.stream().forEach(System.out::println);
		 IntStream.of(numbers).allMatch(x -> x % 2 == 0);
		 IntStream.of(numbers).anyMatch(x -> x % 2 == 0);
		 IntStream.range(1, 100).toArray(); // collect into array 1 to 99
		 IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList()); //collect to list 1 to 100
	}


}
