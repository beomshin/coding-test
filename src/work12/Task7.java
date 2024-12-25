package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task7 {

    private static int[][] dir = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0},
    };

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        String[][] table = new String[N][N];

        for (int i = 0; i < N; i++) {
            String text = br.readLine();
            table[i] = text.split("");
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 2; i++) {
            boolean[][] visited = new boolean[N][N];
            int result = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        area(visited, table[j][k], j, k ,table, i);
                        result++;
                    }
                }
            }

            sb.append(result).append(" ");

        }

        System.out.println(sb.toString().trim());
    }

    public static void area(boolean[][] visited, String color, int x, int y, String[][] table, int type) {
        visited[x][y] = true;

        for (int i=0 ; i < dir.length ; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];

            if (!isMove(x1, y1) || visited[x1][y1]) continue;

            if (type == 0 && color.equals(table[x1][y1])) {
                area(visited, color, x1, y1, table, type);
            } else if (type == 1 && (color.equals(table[x1][y1]) || !color.equals("B") && !table[x1][y1].equals("B")) ) {
                area(visited, color, x1, y1, table, type);
            }

        }
    }


    public static boolean isMove(int x, int y) {
        if (x <0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}
