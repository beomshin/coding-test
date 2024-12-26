package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> woks = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            woks.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> twoHand = new ArrayList<>();

        for (int i=0; i < M; i++) {
            for (int j=0; j < M; j++) {
                if (i != j) {
                    int num = woks.get(i) + woks.get(j);
                    if (!twoHand.contains(num)) twoHand.add(num);
                }
            }
        }

        woks.addAll(twoHand);

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 10001);
        Collections.sort(woks);

        for (int i = 1; i <= N; i++) {
            for (Integer wok : woks) {
                if (wok == i) {
                    dp[i] = 1;
                } else if (i - wok > 0) {
                    dp[i] = Math.min(dp[i], dp[i - wok] + dp[wok]);
                }
            }
        }

        if (dp[N] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }


    }
}
