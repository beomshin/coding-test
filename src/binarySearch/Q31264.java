package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N;i ++) score[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(score);

        double min = A;

        for (int i=0; i < M; i++) min = min / 2;

        int target = (int) Math.ceil(min);

        int left = 0;
        int right = N - 1;

        int min_score = Integer.MAX_VALUE;

        while (left <= right) {


            int mid = (left + right) / 2;

            if (min_score > score[mid]
                    && score[mid] >= target) {
                min_score = score[mid];
            }

            if (score[mid] > target) {
                right = mid - 1;
            } else if (score[mid] < target) {
                left = mid + 1;
            } else {
                min_score = Math.min(min_score, score[mid]);
                break;
            }

        }

        System.out.println(min_score);
    }


}
