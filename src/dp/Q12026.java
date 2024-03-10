package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q12026 {

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] boj = br.readLine().split("");
        long[][] dp = new long[boj.length][3];
        for (int i=0; i < boj.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        for (int i=1; i < N; i++) {
            String current = boj[i];
            for (int j=0; j < i; j++) {
                if (current.equals("B") && boj[j].equals("J")) {
                    dp[i][0] = cal(dp, i, j, 0, 2);
                } else if (current.equals("O") && boj[j].equals("B")) {
                    dp[i][1] = cal(dp, i, j, 1, 0);
                } else if (current.equals("J") && boj[j].equals("O")) {
                    dp[i][2] = cal(dp, i, j, 2, 1);
                }
            }

        }

        String last = boj[boj.length-1];
        if (last.equals("B")) {
            System.out.println(dp[boj.length - 1][0] == Integer.MAX_VALUE ? "-1" : dp[boj.length - 1][0]);
        } else if (last.equals("O")){
            System.out.println(dp[boj.length - 1][1] == Integer.MAX_VALUE ? "-1" : dp[boj.length - 1][1]);
        } else if (last.equals("J")) {
            System.out.println(dp[boj.length - 1][2] == Integer.MAX_VALUE ? "-1" : dp[boj.length - 1][2]);
        }

    }

    public static long cal(long[][] dp, int cur, int prev, int i , int j) {
        int loc = cur - prev;
        long cost = loc * loc;
        return Math.min(dp[cur][i], dp[prev][j] + cost);
    }

}
