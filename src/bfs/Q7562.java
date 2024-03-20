package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q7562 {

    static int[][] dir = {
            {-2, -1,}, {-2, 1},
            {-1, -2}, {1, -2},
            {-1, 2}, {1, 2},
            {2, -1}, {2, 1}
    };

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t  = Integer.parseInt(st.nextToken());

        for (int i=0; i < t ; i++) {
            int l = Integer.parseInt(br.readLine());
            int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(bfs(l, loc, target));
        }

    }


    public static int bfs(int l, int[] loc, int[] target) {

        int[][] costs = new int[l][l];
        boolean[][] visited = new boolean[l][l];

        for (int i=0; i < l ; i++) Arrays.fill(costs[i], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{loc[0], loc[1], 0});

        while (!queue.isEmpty()) {

            int[] val = queue.poll();
            int x = val[0];
            int y = val[1];
            int cost = val[2];

            if (visited[x][y] && cost >= costs[x][y]) {
                continue;
            }

            visited[x][y] = true;
            costs[x][y] = Math.min(costs[x][y], cost);

            for (int[] d : dir) {
                int x2 = val[0] + d[0];
                int y2 = val[1] + d[1];

                if (isTrue(x2, y2, l)) {
                    queue.add(new int[]{x2, y2, cost + 1});
                }

            }

        }

        return costs[target[0]][target[1]];
    }

    public static boolean isTrue(int x, int y, int l) {
        return x >= 0 && y >= 0 && x < l && y < l;
    }


}
