package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2217 {

    public static void main(String[] args) throws IOException {
        greedy();
    }

    public static void greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i=0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int size = 1;
        while (!priorityQueue.isEmpty()) {
            int weight = priorityQueue.poll();
            if (answer < weight * size) answer = weight * size;
            size++;
        }

        System.out.println(answer);
    }
}
