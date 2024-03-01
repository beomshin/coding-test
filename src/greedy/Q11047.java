package greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/Q11047
 */
public class Q11047 {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        greedy();
    }

    public static void greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];

        for (int i=n-1; i >= 0 ;i--) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i < n; i++) {
            k = minus(coin[i], k);
        }
        System.out.println(answer);
    }

    public static int minus(int coin, int amount) {
        if (coin > amount) return amount;
        answer += amount / coin;
        return  amount % coin;
    }
}
