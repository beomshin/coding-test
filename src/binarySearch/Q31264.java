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

        for (int i =0 ; i < N; i++) {
            int target = score[i];
            int sum = maxScore(score, target) + maxScore(score, target + ( 2 * target)) + maxScore(score, target + ( 3 * target));

            System.out.println(maxScore(score, target + ( 2 * target)));
            System.out.println(maxScore(score, target + ( 3 * target)));
            if (sum >= A) {
                System.out.println(target);
                return;
            }
        }

    }

    public static int maxScore(int[] score, int target) {

        int max_score = 0;
        int left = 0;
        int right = score.length - 1;

        while (left <= right) {


            int mid = (left + right) / 2;

            if (max_score <= score[mid]
                    && score[mid] <= target) {
                max_score = Math.max(max_score, score[mid]);
            }

            if (score[mid] > target) {
                right = mid - 1;
            } else if (score[mid] < target) {
                left = mid + 1;
            } else {
                max_score = Math.max(max_score, score[mid]);
                break;
            }

        }

        return max_score;

    }
}
