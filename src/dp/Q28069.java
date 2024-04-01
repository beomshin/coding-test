package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q28069 {

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[2][N + 1];

        Arrays.fill(dp[1], 1000000); // 최대 행동수로 세팅
        dp[1][0] = 0; // 맨 처음 0번 행동
        dp[0][0] = 1; // 0번째 계단 세팅

        for (int i=0 ; i < N + 1; i++) {
            if (dp[0][i] == 1) { // 해당 계단을 밝을수 있으면
                int n = i+1;
                if (n < N+1) {
                    dp[1][n] = Math.min(dp[1][n], dp[1][i]+1); // 행동 수 최소값 DP
                    dp[0][n] = 1; // 다음 계단 이동 가능 세팅
                }

                n = i + i/2;
                if (n < N+1) {
                    dp[1][n] = Math.min(dp[1][n], dp[1][i]+1); // 행동 수 최소값 DP
                    dp[0][n] = 1; // 다음 계단 이동 가능 세팅
                }

            }

        }

        if (dp[1][N] <= K) { // 김밥 가게 위치 행동수로 이동 가능 체크
            System.out.println("minigimbob");
        } else {
            System.out.println("water");
        }

    }
}
