package service;

import static java.util.Map.Entry.comparingByValue;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountRepeatCharacter {
    public void countMaxRepeatChar(String str) {
        str.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(character -> (char) character)
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .ifPresentOrElse(entry -> System.out.println("[\"" + entry.getKey() + "\", " + entry.getValue() + "]"),
                        () -> System.out.println("String is empty"));
    }
}
