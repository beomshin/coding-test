package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5913 {

    static int answer = 0;
    static int distance = 0;
    static int[][] dir = { {0,1}, {0,-1}, {1,0}, {-1,0} };
    static boolean[][] block = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            block[n1-1][n2-1] = true;
        }

        distance = (25 - N) / 2;
        dfs(0, 0, new boolean[5][5], 0, false);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, boolean[][] visited, int loc, boolean flag) {
        if (loc == distance) {
            if (!flag) {
                dfs(x, y, visited,0, true);
            } else if (x == 4 && y == 4) {
                answer++;
            }
            return;
        }

        visited[x][y] = true;
        for (int i=0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (isTrue(x1, y1, visited)) {
                dfs(x1, y1, visited, loc + 1, flag);
            }
        }
        visited[x][y] = false;

    }

    public static boolean isTrue(int x, int y, boolean[][] visited) {
        if (x >=0 && y >=0 && x < 5 && y < 5 && !visited[x][y] && !block[x][y]) {
            return true;
        }
        return false;
    }


}
