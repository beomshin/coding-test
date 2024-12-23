package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] box = new int[n];

        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n];

        dp[0][0] = box[0] == 1 ? 1 : 0;
        dp[1][0] = box[0] == 2 ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (box[i] == box[i - 1]) {
                if (box[i] == 1) {
                    dp[0][i] = dp[0][i - 1] <= 0 ? 1 : dp[0][i - 1] + 1;
                    dp[1][i] = dp[1][i - 1] <= 0 ? 0 : dp[1][i - 1] - 1;
                } else if (box[i] == 2) {
                    dp[0][i] = dp[0][i - 1] <= 0 ? 0 : dp[0][i - 1] - 1;
                    dp[1][i] = dp[1][i - 1] <= 0 ? 1 : dp[1][i - 1] + 1;
                }
            } else {
                dp[0][i] = dp[0][i-1] <= 0 ? 1 : dp[0][i-1] + (box[i] == 1 ? 1 : -1);
                dp[1][i] = dp[1][i-1] <= 0 ? 1 : dp[1][i-1] + (box[i] == 2 ? 1 : -1);
            }
        }

        int max1 = Arrays.stream(dp[0]).max().getAsInt();
        int max2 = Arrays.stream(dp[1]).max().getAsInt();
        int max = Math.max(max1, max2);
        System.out.println(max);

    }
}
