import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String studentID;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println("--------------");
    }

    public void updateAge(int newAge) {
        this.age = newAge;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding sample students
        Student student1 = new Student("S001", "Alice", 20);
        student1.addCourse("Mathematics");
        student1.addCourse("Physics");
        students.add(student1);

        Student student2 = new Student("S002", "Bob", 22);
        student2.addCourse("Computer Science");
        students.add(student2);

        Student student3 = new Student("S003", "Charlie", 21);
        student3.addCourse("Chemistry");
        students.add(student3);

        // Display details of all students
        System.out.println("Details of all students:");
        students.forEach(Student::displayStudentDetails);

        // Display students enrolled in a specific course (e.g., "Computer Science")
        String targetCourse = "Computer Science";
        System.out.println("Students enrolled in " + targetCourse + ":");
        students.stream()
                .filter(student -> student.getCourses().contains(targetCourse))
                .forEach(Student::displayStudentDetails);

        // Update the age of a specific student (e.g., student with ID "S001")
        String targetStudentID = "S001";
        int newAge = 21;
        System.out.println("Updating age of student with ID " + targetStudentID + " to " + newAge + ":");
        students.stream()
                .filter(student -> student.getStudentID().equals(targetStudentID))
                .forEach(student -> student.updateAge(newAge));

        // Display updated details of all students
        System.out.println("Details of all students after update:");
        students.forEach(Student::displayStudentDetails);

        // Calculate and display the average age of all students
        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age of all students: " + averageAge);
    }
}
