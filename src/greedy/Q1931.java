package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class Q1931 {

    public static void main(String[] args) throws IOException {
        greedy();
    }

    public static void greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }));

        for (int i=0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            priorityQueue.add(new int[]{start, end});
        }

        int time = 0;
        int count = 0;

        while (!priorityQueue.isEmpty()) {
            int[] table = priorityQueue.poll();
            int start = table[0];
            int end =  table[1];
            if (time <= start && time <= end) {
                time = end;
                count ++;
            }
        }

        System.out.println(count);

    }
}
