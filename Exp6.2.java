implement Java program that uses lambda expressions and Stream API to filter students who scored above 75%, sort them by marks, and display their names.
SOLUTION:
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ayush", 85),
            new Student("Rajeev", 70),
            new Student("Vinay", 90),
            new Student("David", 60),
            new Student("Prakul", 80)
        );

        List<String> topStudents = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .collect(Collectors.toList());

        System.out.println("Top-performing students: " + topStudents);
    }
}

Step 1: Create the Student Class
- Define a Student class with attributes:
    name (String)
    marks (double)
- Implement a constructor to initialize these values.
- Add a display method to print student details.

Step 2: Create the StudentFilterSort Class
- Create a list of students with sample data.
- Use Streams Class to:
      Filter students who scored above 75%.
      Sort students by marks in descending order.
      Collect the results into a new list.
- Use forEach() with a method reference to display results.ts.


Test Case	                        Input Data	                                                 Expected Output
Case 1:         Normal Case	Alice (80), Bob (72), Charlie (90), David (65), Eve (85)	         Charlie, Eve, Alice (Sorted by marks)
Case 2:         All Below 75%	Bob (70), David (60), Frank (65)	                               No output (Empty List)
Case 3:         Same Marks	Alice (80), Bob (80), Charlie (85)                                 Charlie, Alice, Bob (Sorted by marks, then by name)
Case 4:         Single Student Above 75%	Alice (60), Bob (50), Charlie (90)	                 Charlie (Only one student)
