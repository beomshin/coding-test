package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/12435
 */
public class Q12435 {

    private static HashMap<Integer, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] tcase = new int[t][2];
        int max = 0;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < t ; i++) {
            StringTokenizer st=  new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            tcase[i][0] = N;
            tcase[i][1] = M;
            max = Math.max(max, N);
        }

        HashMap<Integer, Integer> young = new HashMap<>();
        int[] brothers = new int[max+1];
        for (int i=2; i <= max; i++) {
            int k= i + i;
            while (k <= max) {
                brothers[k]++;
                young.put(k, Math.min(young.getOrDefault(k, i), i));
                k += i;
            }
        }

        for (int i=0; i < t; i++) {
            int count = brothers[tcase[i][0]];
            int sum = 0;
            for (int j=2; j < tcase[i][0]; j++) {
                if (count != 0 && count == brothers[j] && young.getOrDefault(j, 0) >= tcase[i][1]) {
                    sum++;
                }
            }
            sb.append("Case #").append(i+1).append(": ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

}
