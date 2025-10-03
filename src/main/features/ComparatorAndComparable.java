package src.main.features;

import java.util.*;

public class ComparatorAndComparable {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,2,7,23,44,12);
        list.sort(Collections.reverseOrder());

        List<Student> students = new ArrayList<>();
        students.add(new Student(4, "Harshada", "Malgonde", 53));
        students.add(new Student(3, "Pradnya", "Deshmukh", 62));
        students.add(new Student(1, "Rasvi", "Jambhulkar", 99));
        students.add(new Student(5, "Jaymin", "Desai", 11));
        students.add(new Student(2, "Aarya", "Jambhulkar", 40));

        System.out.println("Natural order (by ID): ");
        students.sort(null);
        students.forEach(System.out::println);
        
        System.out.println("By Marks:");
        students.sort(StudentComparator::compareByMarks);
        students.forEach(System.out::println);

        System.out.println("By Marks in reverse order:");
        Comparator<Student> studentMarksCom = StudentComparator::compareByMarks;
        students.sort(studentMarksCom.reversed());
        students.forEach(System.out::println);
        
        System.out.println("By First Name:");
        students.sort((a, b) -> StudentComparator.compareByFirstName(a, b));
        students.forEach(System.out::println);


        System.out.println("Natural order using comparator (by ID): ");
        students.sort(new StudentComparator());
        students.forEach(System.out::println);
    }
}
