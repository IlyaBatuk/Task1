package service;

import java.util.*;

public class CountRepeatCharacter {

    public Map<Character, Integer> countMaxRepeatChar(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> countAllChar = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }

        char[] chars = sb.toString().toCharArray();
        int count = 0;

        for (char c : chars) {
            for (char rep : chars) {
                if (rep == c)
                    count++;
            }
            countAllChar.put(count, c);
            count = 0;
        }

        int value = Collections.max(countAllChar.keySet());
        char key = countAllChar.get(value);

        return Collections.singletonMap(key, value);
    }
}
