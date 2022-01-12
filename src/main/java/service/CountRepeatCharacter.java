package service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountRepeatCharacter {
    public void countMaxRepeatChar(String str) {
        str.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresentOrElse(entry -> System.out.println("[\"" + entry.getKey() + "\", " + entry.getValue() + "]"),
                                () -> System.out.println("String is empty"));
    }
}
