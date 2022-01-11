package service;

import entity.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return students.stream().map(Student::getRating).mapToDouble(d -> d.get(subjectName))
                .average().orElseThrow();
    }

    public void printStudentsAndSubjects(List<Student> students) {
        List<String> subjects = new LinkedList<>();

        students.stream().map(Student::getRating)
                .map(Map::keySet).forEach(subjects::addAll);
        subjects = subjects.stream().distinct().collect(Collectors.toList());

        for (String subject : subjects) {
            List<String> forPrintStudentsAndSubjects = new LinkedList<>();
            System.out.print(subject + ": ");

            students.stream().filter(subj -> subj.getRating().get(subject) != null)
                    .forEach(student -> forPrintStudentsAndSubjects.add(student.getName()
                            + ": " + student.getRating().get(subject)));

            System.out.println(forPrintStudentsAndSubjects);

        }
    }
}
