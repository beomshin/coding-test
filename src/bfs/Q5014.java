package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5014
 */
public class Q5014 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[F+1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});

        while (!queue.isEmpty()) {

            int[] val = queue.poll();

            int h = val[0];
            int count = val[1];

            if (h == G) {
                System.out.println(count);
                return;
            } else if (visited[h]) continue;

            int up = h + U;
            int down = h - D;
            visited[h] = true;

            if (up >= 0 && up <= F && !visited[up]) {
                queue.add(new int[]{up, count + 1});
            }

            if (down >= 0 && down <= F && !visited[down]) {
                queue.add(new int[]{down, count + 1});
            }
        }

        System.out.println("use the stairs");
    }
}
