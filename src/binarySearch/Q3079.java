package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3079
 */
public class Q3079 {

    public static void main(String[] args) throws IOException {
        binarySearch();
    }

    public static void binarySearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] gate = new long[N];
        long min = Integer.MAX_VALUE;

        for (int i=0 ; i < N; i++) {
            gate[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, gate[i]);
        }

        long time = binarySearch(0, min * M, gate, M);

        System.out.println(time);
    }


    public static long binarySearch(long start, long end, long[] gate, int count) {
        if (start > end) {
            return start;
        }

        long mid = (start + end) / 2; // 중간 시간
        long sum = 0; // 통과 누적 수
        for (long j : gate) sum += mid / j;

        if (sum > count) { // 시간이 널널
            return binarySearch(start, mid - 1, gate, count);
        } else if (sum < count) { // 시간 부족
            return binarySearch(mid + 1, end, gate, count);
        } else {
            return binarySearch(start, mid - 1, gate, count);
        }
    }

}
