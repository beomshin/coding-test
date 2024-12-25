package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task8 {

    private static int R, C;
    private static int[][] costs, times;

    private static int[][] dir = {
            {0, 0},
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };

    private static int max = 0;

    private static String[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        table = new String[R][C];
        times = new int[R][C];
        costs = new int[R][C];

        for (int i = 0; i < R; i++) {
            String text = br.readLine();
            table[i] = text.split("");
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (table[i][j].equals("G")) {
                    dfs(new Node(i, j, T, 0), new boolean[R][C]);
                }
            }
        }

        System.out.println(max);
    }

    public static void dfs(Node node, boolean[][] visited) {
        if (node.t < 0) {
            max = Math.max(max, node.count);
            return;
        }

        int count = node.count;
        for (int i=0; i < dir.length; i++) {

            int x1 = node.x + dir[i][0];
            int y1 = node.y + dir[i][1];
            boolean flag = false;

            if (!isMove(x1, y1) || table[x1][y1].equals("#")) continue;

            if (!visited[node.x][node.y] && table[node.x][node.y].equals("S")) {
                count = node.count + 1;
                visited[node.x][node.y] = true;
                flag = true;
            }

            dfs(new Node(x1, y1, node.t-1, count), visited);

            if (visited[node.x][node.y] && table[node.x][node.y].equals("S") && flag) {
                count = node.count;
                visited[node.x][node.y] = false;
            }
        }


    }

    public static class Node {
        int x, y, t;
        int count;

        public Node(int x, int y, int t, int count) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.count = count;
        }
    }


    public static boolean isMove(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

}
