package struct;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1655
 */
public class Q1655 {

    public static void main(String[] args) throws IOException {
        struct();
    }

    public static void struct() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                max.add(num);
            } else {
                min.add(num);
            }

            if (!max.isEmpty() && ! min.isEmpty()) {
                if (max.peek() > min.peek()) {
                    int temp = max.poll();
                    max.add(min.poll());
                    min.add(temp);
                }
            }

            bw.write(max.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
