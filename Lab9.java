// Student.java
public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

// Main.java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create ArrayList of Students
        ArrayList<Student> students = new ArrayList<>();

        // 🔹 CREATE - Add students
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));

        System.out.println("Initial Student List:");
        displayStudents(students);

        // 🔹 READ - Access a student
        System.out.println("\nStudent at index 1: " + students.get(1));

        // 🔹 UPDATE - Modify a student's marks
        students.get(0).setMarks(90);
        System.out.println("\nAfter updating Alice's marks:");
        displayStudents(students);

        // 🔹 DELETE - Remove a student
        students.remove(2);  // removes Charlie
        System.out.println("\nAfter removing Charlie:");
        displayStudents(students);

        // 🔹 Traverse using Iterator
        System.out.println("\nTraversing with Iterator:");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println(s);
        }
    }

    // Helper method to display all students
    public static void displayStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
