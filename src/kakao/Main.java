package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String a = solution("John Doe, Peter Parker, Mary Jane Watson-parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "example");
        System.out.println(a);
    }


    public static String solution(String S, String C) {
        // Implement your solution here

        List<String> list = new ArrayList<>();
        HashMap<String, Integer> overlap = new HashMap<>();
        String[] arr = S.split(",");

        for (int i = 0; i < arr.length; i++) {
            String[] names =  arr[i].trim().split(" ");
            String name = "";

            if (names.length == 3) {
                name += names[0].substring(0, 1).toLowerCase()
                        + names[1].substring(0, 1).toLowerCase()
                        + names[2].replaceAll("-", "").toLowerCase().substring(0, Math.min(names[2].length(), 8));
            } else {
                name += names[0].substring(0, 1).toLowerCase()
                        + names[1].replaceAll("-", "").toLowerCase().substring(0, Math.min(names[1].length(), 8));
            }

            if (!overlap.containsKey(name)) {
                overlap.put(name, 2);
            } else {
                Integer count = overlap.get(name);
                overlap.put(name, count + 1);
                name += count;
            }

            String text = arr[i].trim()  + " <" + name + "@" + C.toLowerCase() + ".com>";

            list.add(text);
        }

        return list.stream().collect(Collectors.joining(", "));
    }
}
