package entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Student {

    private Map<String, Integer> rating;
    private String name;

    public Student(String name){
        this.rating = new HashMap<>();
        this.name = name;
    }

    public Student rate(String subject, Integer rate){
        rating.put(subject, rate);
        return this;
    }
}
