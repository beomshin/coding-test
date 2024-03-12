package dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * https://www.acmicpc.net/problem/4883
 */
public class Q4883 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int no = 1;
        while (true) {

            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                bw.flush();
                return;
            }

            int[][] map = new int[N][3];
            int[][] dp = new int[N][3];

            for (int i=0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
                map[i][2] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = map[0][1];
            dp[0][2] = Math.min(map[0][1] + map[0][2], dp[0][1] + map[0][2]);

            for (int i=1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][0];
                dp[i][1] = Math.min(dp[i][0], Math.min(dp[i-1][2], Math.min(dp[i-1][0], dp[i-1][1]))) + map[i][1];
                dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2])) + map[i][2];
            }

            int answer = dp[N-1][1];

            bw.write(no + ". " + answer + "\n");
            no++;
        }

    }
}
