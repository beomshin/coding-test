package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12101 {

    static int N, K;
    static PriorityQueue<String> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<String>[] dp = new ArrayList[N+1];
        for (int i=1; i <= N; i++) dp[i] = new ArrayList<>();

        dp[1].add("1");
        dp[2].add("1+1");
        dp[2].add("2");
        dp[3].add("1+2");
        dp[3].add("1+1+1");
        dp[3].add("2+1");
        dp[3].add("3");

        for (int i=4; i <= N; i++) {
            for (int j=1; j <=3 ; j++) {
                for (String s : dp[i-j]) {
                    dp[i].add(s + "+" + j);
                }
            }
        }

        if (dp[N].size() < K) {
            System.out.println("-1");
        } else {
            Collections.sort(dp[N]);
            System.out.println(dp[N].get(K-1));
        }

    }


}
