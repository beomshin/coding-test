package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q25194 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] works = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[8];
        dp[0] = 1;

        for (int i=0; i < N; i++) {

            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int j=0; j < dp.length; j++) {

                if (dp[j] > 0) {
                    int num = j + works[i];
                    temp[num%7] += 1;
                }
            }
            dp = temp;
        }



        if (dp[4] > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
