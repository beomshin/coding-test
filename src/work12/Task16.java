package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task16 {

    private static int N;
    private static String[][] table;
    private static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    private static int[][] dir = {
            {0, 1},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        table = new String[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = st.nextToken();
            }
        }

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        dfs(0, 0, 0, visited, "+");

        System.out.println(max + " " + min);
    }

    public static void dfs(int x, int y, long ans, boolean[][] visited, String op) {
        if (x == N - 1 && y == N - 1) {
            int num = Integer.parseInt(table[x][y]);
            ans = cal(ans, num, op);
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];

            if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= N || visited[x1][y1]) continue;

            visited[x1][y1] = true;

            int type = (x+y) % 2;
            if (type == 0) { // 숫자
                int num = Integer.parseInt(table[x][y]);
                dfs(x1, y1, cal(ans, num, op), visited, null);
            } else {  // 문자
                dfs(x1, y1, ans, visited, table[x][y]);
            }

            visited[x1][y1] = false;
        }

    }

    public static long cal(long ans, int num, String op) {
        long result = 0;
        switch (op) {
            case "+": result = ans + num; break;
            case "-": result = ans - num; break;
            case "*": result = ans * num; break;
        }
        return result;
    }
}
