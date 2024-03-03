package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1263
 */
public class Q1263 {

    public static void main(String[] args) throws IOException {
        greedy();
    }

    public static void greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }));
        for (int i=0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            priorityQueue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int time = priorityQueue.peek()[1];

        while (!priorityQueue.isEmpty()) {

            if (priorityQueue.peek()[1] < time) {
                time--;
                continue;
            }

            if (priorityQueue.peek()[1] >= time) {
                int[] work = priorityQueue.poll();
                time -= work[0];
            }

        }


        System.out.println(time >= 0 ? time : "-1");

    }
}
