package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10835 {

    static int N;
    static int[][] dp;
    static int[] A,B;

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(topDown(0, 0));

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }

    public static int topDown(int l, int r) {
        if (l == N || r == N) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        dp[l][r] = Math.max(topDown(l+1, r + 1), topDown(l+1, r));

        if (A[l] > B[r]) {
            dp[l][r] = Math.max(dp[l][r], topDown(l, r+1) + B[r]);
        }

        System.out.println("l : " + l + " r : " + r + " : " + dp[l][r]);

        return dp[l][r];
    }
}
