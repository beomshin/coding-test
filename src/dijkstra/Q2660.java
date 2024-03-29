package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2660 {

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        boolean[][] route = new boolean[N+1][N+1];
        int n1, n2;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            if (n1 == -1 && n2 == -1 ) break;
            route[n1][n2] = true;
            route[n2][n1] = true;
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] map = new int[N+1][N+1];

        for (int i=1; i < N+1; i++) Arrays.fill(map[i], Integer.MAX_VALUE);

        for (int i=1; i < N + 1; i++) {
            for (int j=1; j < N + 1; j++) {
                if (route[i][j] && i != j) {
                    queue.add(new int[]{i, j, 1});
                }
            }
        }

        int[] dp = new int[N+1];

        while (!queue.isEmpty()) {

            int[] val =  queue.poll();
            int start = val[0];
            int loc = val[1];
            int cost = val[2];

            map[start][loc] = Math.min(map[start][loc], cost);
            dp[start] = Math.max(dp[start], map[start][loc]);

            for (int i=1; i < N + 1; i++) {
                if (loc != i && start != i && route[loc][i] && map[start][i] > cost + 1) {
                    queue.add(new int[]{start, i, cost + 1});
                }


            }

        }


        int answer= Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=1; i < N+1; i++) {
            if (dp[i] < answer) {
                list.clear();
                answer = dp[i];
                list.add(i);
            } else if (dp[i] == answer) {
                list.add(i);
            }

        }
        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        sb.append(answer).append(" ").append(list.size()).append("\n");
        for (int v : list) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);

    }


}
