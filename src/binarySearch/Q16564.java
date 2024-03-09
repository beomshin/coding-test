package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * https://www.acmicpc.net/problem/16564
 */
public class Q16564 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] levels = new int[N];

        long max = Integer.MAX_VALUE;
        long min = Integer.MAX_VALUE;

        for (int i=0; i < N; i++) {
            int level = Integer.parseInt(br.readLine());
            levels[i] = level;
            min = Math.min(min, level);
        }

        long answer = 0;

        while (min <= max) {

            long mid = (min + max) / 2;
            long count = 0;
            for (int i=0; i < N; i++) {
                if (mid > levels[i]) count += mid - levels[i];
            }

            if (count <= K) {
                min = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
