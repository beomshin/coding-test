package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/31264
 */
public class Q31264 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        int[] score = new int[N];

        long max = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N;i ++) {
            score[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, score[i]);
        }

        Arrays.sort(score);

        long min = 1;

        while (min <= max) {

            long sum = 0;
            long mid = (min + max) / 2;

            for (int i=0; i < M; i++) {
                sum += getScore(score, mid + sum);
            }

            if (sum >= A) {
                max = mid - 1;
            } else if (sum < A){
                min = mid + 1;
            }

        }

        System.out.println(min);
    }

    public static long getScore(int[] score, long target) {

        long max_score = 0;
        int left = 0;
        int right = score.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (target >= score[mid]) {
                max_score = Math.max(max_score, score[mid]);
            }

            if (score[mid] > target) {
                right = mid - 1;
            } else if (score[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }

        }

        return max_score;

    }
}
