package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q21600 {


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] chat = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            chat[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i=1 ; i < N ; i++ ) {
            int h = chat[i];

            if (h > dp[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = Math.min(dp[i-1], h);
            }
        }

        int answer = 0;

        for (int v : dp) answer = Math.max(answer, v);

        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }

}
