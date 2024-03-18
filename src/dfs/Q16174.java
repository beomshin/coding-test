package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16174 {

    static int N;
    static boolean[][] visited;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0, 0);

        if (answer) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }

    }


    public static void dfs(int[][] map, int x, int y) {
        visited[x][y] = true;

        int p = map[x][y];

        if (x == N-1 && y == N-1) {
            answer = true;
        }

        if (x + p < N && !visited[x + p][y]) {
            dfs(map, x + p, y);
        }

        if (y + p < N && !visited[x][y + p]) {
            dfs(map, x, y + p);
        }


    }

}
