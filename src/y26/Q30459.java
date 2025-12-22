package y26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q30459 {


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 말뚝의 개수
        int M = Integer.parseInt(st.nextToken()); // 깃대의 개수
        int R = Integer.parseInt(st.nextToken()); // 최대 현수막 넓이

        int[] location = new int[N];
        int[] heights = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(location);
        Arrays.sort(heights);

        double answer = -1;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                int a1 = location[i];
                int a2 = location[j];

                int bottom = Math.abs(a1 - a2);
                set.add(bottom);


            }
        }

        for (int bottom : set) {

            for (int i = 0; i < M; i++) {

                int height = heights[i];

                double size = (double) (height * bottom) / 2;

                if (size <= R) {
                    answer = Math.max(answer, size);
                }

            }

        }


        if (answer < 0) {
            System.out.println(-1);
        } else {
            System.out.printf("%.1f", answer);
        }

    }
}
