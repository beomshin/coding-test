package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task19 {

    private static int[][] dir1 = {
            {-1, -1},
            {0, -1},
            {-1, 0}
    };

    private static int[][] dir2 = {
            {1, -1},
            {0, -1},
            {-1, 0}
    };

    private static int N, M;

    private static long[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        boolean[][] hole = new boolean[N][M];
        table = new long[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            hole[x][y] = true;
        }

        table[0][0] = 1;


        for (int y = 0; y < M; y++) {

            boolean type = y % 2 == 0;

            for (int x = 0; x < N; x++) {

                if (hole[x][y]) continue;

                if (type) { // 홀수
                    table[x][y] += isRoute(dir1, x, y);
                } else { // 짝수
                    table[x][y] += isRoute(dir2, x, y);
                }

            }
        }

        System.out.println(table[N - 1][M - 1]);
    }

    private static long isRoute(int[][] dir, int x, int y) {
        long ans = 0;
        for (int i = 0; i < dir.length; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;

            ans += table[newX][newY];
        }

        return ans % (1000000007);
    }
}
