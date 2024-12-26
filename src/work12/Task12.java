package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Task12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String d1 = st.nextToken();

        st = new StringTokenizer(br.readLine());

        String d2 = st.nextToken();

        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();

        for (char c : d1.toCharArray()) {
            deque1.add(c);
        }

        for (char c : d2.toCharArray()) {
            deque2.add(c);
        }

        while (!deque1.isEmpty() && !deque2.isEmpty() && deque1.peek() == deque2.peek()) {
            deque1.pollFirst();
            deque2.pollFirst();
        }

        while (!deque1.isEmpty() && !deque2.isEmpty() && deque1.peekLast() == deque2.peekLast()) {
            deque1.pollLast();
            deque2.pollLast();
        }


        System.out.println(deque2.size());
    }
}
