package dp;

import java.io.*;
import java.util.Arrays;

public class Q11058 {

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i-1] + 1, dp[i]);

            long cost = dp[i];
            long ans = 1;

            for (int j=i + 3; j <= N ; j++ ) {
                dp[j] = Math.max(dp[j], dp[i] +  cost * ans);
                ans++;
            }

        }

        System.out.println(dp[N]);

    }

}
