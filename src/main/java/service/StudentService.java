package service;

import entity.Student;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class StudentService {

    public void findBestMatchingPerson(List<Student> students, String subject, Integer rating) {
        if (isExistSubject(students, subject)) {
            if (isExistStudentsWithRating(students, subject, rating)) {
                System.out.print(subject + " : ");
                students.stream()
                        .filter(student -> student.getRating().get(subject) >= rating)
                        .map(Student::getName)
                        .forEach(name -> System.out.print(name + "; "));
            } else {
                students.stream()
                        .max(comparing(student -> student.getRating().get(subject)))
                        .ifPresent(student -> System.out.println(subject + " : " + student.getName()));
            }
        } else {
            System.out.println("Subject not found");
        }

    }

    private boolean isExistSubject(List<Student> students, String subject){
        return students.stream()
                .anyMatch(student -> student.getRating().containsKey(subject));
    }

    private boolean isExistStudentsWithRating(List<Student> students, String subject, Integer rating){
        return students.stream()
                .anyMatch(student -> student.getRating().get(subject) >= rating);
    }
}
