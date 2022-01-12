package service;

import entity.Student;

import java.util.List;
import java.util.Objects;

public class StudentService {

    public Double averageRatingForSubject(List<Student> students, String subjectName) {
        return students.stream()
                .map(Student::getRating)
                .mapToDouble(d -> d.get(subjectName))
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
                        .forEach(student -> System.out.print(student.getName() + ": "
                                + student.getRating().get(subject) + "; ")));
    }
}
