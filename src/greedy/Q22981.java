package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q22981 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] works = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i < N; i++) {
            works[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(works);

        long max = 0;

        for (int i=1; i < N; i++) {
            long num = ((N-i) * works[i]) + (i * works[0]);
            max = Math.max(max, num);
        }

        long answer = K / max + (K % max == 0 ? 0 : 1);

        System.out.println(answer);

    }
}
