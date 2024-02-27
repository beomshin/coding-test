package struct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Q1764 {

    public static void main(String[] args) {
        struct();
    }

    public static void struct() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        sc.nextLine();

        ArrayList<String> answer = new ArrayList<>();
        HashSet<String> names = new HashSet<>();
        for (int i=0; i< n; i++) {
            names.add(sc.nextLine().trim());
        }
        for (int i=0; i< m; i++) {
            String name = sc.nextLine().trim();
            if (names.contains(name)) {
                answer.add(name);
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        answer.forEach(it -> System.out.println(it));

    }
}
