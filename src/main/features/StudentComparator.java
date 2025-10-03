package src.main.features;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
    
    public static int compareByFirstName(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
    
    public static int compareByLastName(Student o1, Student o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

    public static int compareByMarks(Student o1, Student o2) {
        return Integer.compare(o1.getMarks(), o2.getMarks());
    }
}

