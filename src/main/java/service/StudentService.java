package service;

import entity.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StudentService {

    public List<Student> initListStudents() {
        List<Student> students = new LinkedList<>();

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

        return students;
    }

    public Double averageRatingForSubject(List<Student> students, String subjectName) {
        return students.stream()
                .map(Student::getRating)
                .mapToDouble(rating -> rating.get(subjectName))
                .average()
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public void printStudentsAndSubjects(List<Student> students) {
        students.stream()
                .map(Student::getRating)
                .flatMap(stringIntegerMap -> stringIntegerMap.keySet().stream())
                .distinct()
                .peek(subject -> System.out.print("\n" + subject + " = "))
                .forEach(subject -> students.stream()
                        .filter(subj -> Objects.nonNull(subj.getRating().get(subject)))
                        .forEach(student -> printStudentForMethod(student.getName(), student.getRating().get(subject))));
    }

    private void printStudentForMethod(String name, String subject){
        System.out.print(name + ": " + subject + "; ");
    }
}
