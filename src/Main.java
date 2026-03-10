import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String group;
    double gpa;

    Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String toString() {
        return name + " (" + group + ", " + gpa + ")";
    }
}

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,5,4,4,2);
        List<String> names = Arrays.asList("Anna","Bek","Angela","Chyngyz","Alina");

        // Sample students
        List<Student> students = Arrays.asList(
                new Student("Aliya","A1",3.9),
                new Student("Diana","A1",3.4),
                new Student("Aman","B1",3.7),
                new Student("Janat","B1",3.2),
                new Student("Sara","A2",3.8)
        );

        // 1
        List<Integer> even = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + even);

        // 2
        List<String> upper = names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Uppercase: " + upper);

        // 3
        long countA = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Names starting with A: " + countA);

        // 4
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Sorted descending: " + sortedDesc);

        // 5
        int max = numbers.stream()
                .mapToInt(n -> n)
                .max()
                .getAsInt();

        int min = numbers.stream()
                .mapToInt(n -> n)
                .min()
                .getAsInt();

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        // 6
        List<Integer> unique = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique numbers: " + unique);

        // 7
        String joined = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Joined string: " + joined);


        // 8
        Map<String, List<Student>> groups =
                students.stream()
                        .collect(Collectors.groupingBy(s -> s.group));

        System.out.println("Grouped students: " + groups);

        // 9
        double avgGpa = students.stream()
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0);

        System.out.println("Average GPA: " + avgGpa);

        // 10
        List<Student> top3 = students.stream()
                .filter(s -> s.gpa > 3.5)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top students: " + top3);


        // 11
        long countTop = students.stream()
                .filter(s -> s.gpa > 3.5)
                .count();

        System.out.println(" GPA > 3.5: " + countTop);
    }
}

