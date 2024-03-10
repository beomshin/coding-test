package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1149
 */
public class Q1149 {

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N][3];

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][3];

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        for (int i=1; i < N; i++) {
            dp[i][0] = house[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = house[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = house[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int answer = Math.min(dp[N-1][0], dp[N-1][1]);
        answer = Math.min(answer, dp[N-1][2]);
        System.out.println(answer);
    }
}
