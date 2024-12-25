
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Task6 {

    private static int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int result = 0;
    private static int result_len = 0;
    private static  int result_max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int len = 0, max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (table[i][j] != 0) {

                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[N][M];


                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] d = queue.poll();
                        int x = d[0];
                        int y = d[1];
                        int cost = d[2];

                        boolean flag = false;
                        for (int k = 0; k < 4; k++) {
                            int x1 = x + dir[k][0];
                            int y1 = y + dir[k][1];

                            if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= M || visited[x1][y1]) continue;

                            if (table[x1][y1] != 0) {
                                flag = true;
                                visited[x1][y1] = true;
                                queue.add(new int[]{x1, y1, cost + 1});
                            }
                        }

                        if (!flag && cost >= len) {
                            if (cost > len) {
                                max = table[i][j] + table[x][y];
                            } else {
                                max = Math.max(max, table[i][j] + table[x][y]);
                            }
                            len = cost;
                        }

                    }

                }
            }
        }

        System.out.println(max);

    }
}
