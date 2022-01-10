import entity.Student;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();

        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Bob");
        Student student2 = new Student("Maria");
        Student student3 = new Student("Tom");
        Student student4 = new Student("Ilya");
        Student student5 = new Student("Nikolay");

        student1.rate("Math", 7);
        student1.rate("Physics", 8);
        student2.rate("Math", 8);
        student2.rate("Physics", 7);
        student3.rate("Math", 6);
        student3.rate("Physics", 6);
        student4.rate("Math", 9);
        student4.rate("Physics", 8);
        student5.rate("Math", 5);
        student5.rate("Physics", 5);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        studentService.printStudentsAndSubjects(students);

        System.out.println(studentService.averageRatingForSubject(students, "Math"));


    }
}
