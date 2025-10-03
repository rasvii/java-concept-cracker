package src.main.features;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args){
        /*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        long count = numbers.stream().filter(x -> x%2 == 0).count();
        
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rasvi", "Jambhulkar", 99));
        students.add(new Student(2, "Aarya", "Jambhulkar", 40));
        students.add(new Student(3, "Pradnya", "Deshmukh", 62));
        students.add(new Student(4, "Harshada", "Malgonde", 53));
        students.add(new Student(5, "Jaymin", "Desai", 11));
        
        List<String> names = students.stream().map(x -> x.getFirstName().toUpperCase()).toList();
        
        names.forEach(System.out::println);

        Map<Integer, Student> map = students.stream().collect(Collectors.toMap(Student::getId, x->x));
        List<String> concatNames = students.stream().map(x -> x.getFirstName() + " " + x.getLastName()).toList();
        
        concatNames.forEach(System.out::println);
        
        Student s = new Student(1, "Rasvi", "Jambhulkar", 99);*/

        
        //Predicate
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isGreaterThan100 = x -> x > 100;
        System.out.println(isEven.and(isGreaterThan100).test(80));

        //Function
        Function<Integer, Integer> doubleIt = x -> x*2;
        Function<Integer, Integer> tripleIt = x -> x*3;
        System.out.println(doubleIt.apply(500));
        System.out.println(doubleIt.andThen(tripleIt).apply(2)); //first doubleIt runs then tripleIt
        System.out.println(doubleIt.compose(tripleIt).apply(8)); //first tripleIt runs then doubleIt
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(10));
        
        //Consumer
        Consumer<String> print = System.out::println;
        print.accept("hello");
        List<Integer> nums = Arrays.asList(1,2,3,4);
        Consumer<List<Integer>> printList = x -> {
            for(int i: x) {
                System.out.println(i);
            }
        };
        printList.accept(nums);
        
        //Supplier
        Supplier<String> giveHelloWord = () -> "Hello world!";
        System.out.println(giveHelloWord.get());
        
        //Combined Example
        Function<Integer, Integer> square = x -> x * x;
        Consumer<Integer> printInt = System.out::println;
        Supplier<Integer> supplier = () -> 100;
        printInt.accept(square.apply(supplier.get()));
        
        //Bi operations
        BiPredicate<Integer, Integer> areEqual = (x,y) -> Objects.equals(x, y);
        BiConsumer<Integer, String> printBoth = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<Integer, String, Integer> addBoth = (x,y) -> x + y.length();
        
        

    }
}
