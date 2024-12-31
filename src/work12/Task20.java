package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task20 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] table = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table);

        int sum = table[2] - table[0];
        int pin = 1;

        for (int i = 3; i < n-1; i +=2) {
            sum += table[i+1] - table[i];
        }

        int ans = sum;

        for (int i = pin+2; i < n-1; i += 2) {
            sum -= table[i-1] - table[i-3];
            sum += table[i-2] - table[i-3];
            sum -= table[i+1] - table[i];
            sum += table[i+1] - table[i-1];
            ans = Math.min(ans, sum);
        }

        System.out.println(ans);
    }
}
