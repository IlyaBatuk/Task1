package service;

import entity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {


    public Double averageRatingForSubject(List<Student> students, String subjectName){
        return students.stream().map(Student::getRating).mapToDouble(d -> d.get(subjectName))
                .average().orElseThrow();
    }

    public void printStudentsAndSubjects(List<Student> students){
        List<String> subjects = new LinkedList<>();


        students.stream().map(Student::getRating)
                .map(Map::keySet).forEach(subjects::addAll);
        subjects = subjects.stream().distinct().collect(Collectors.toList());

        for(String subject : subjects){
            List<String> forPrintStudentsAndSubjects = new LinkedList<>();
            System.out.print(subject + ": ");

            students.stream().filter(subj -> subj.getRating().get(subject) != null)
                    .forEach(student -> forPrintStudentsAndSubjects.add(student.getName()
                            + ": " + student.getRating().get(subject)));

            System.out.println(forPrintStudentsAndSubjects);

        }
    }
}
