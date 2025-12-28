package y26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14217 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] road = new  int[n+1][n+1];

        for(int i = 1; i <= m; i++){
            st  = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            road[a][b] = 1;
            road[b][a] = 1;
        }

        st = new  StringTokenizer(br.readLine());

        int q =  Integer.parseInt(st.nextToken());

        int[][] answer = new int[q][n];
        int[] costs = new  int[n+1];

        for (int k=0; k < q; k++) {
            st  = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int i  = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (a == 1) {
                road[i][j] = 1;
                road[j][i] = 1;
            } else if (a == 2) {
                road[i][j] = 0;
                road[j][i] = 0;
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(e -> e[1]));
            queue.add(new int[] {0,1});
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[1] = 0;

            while (!queue.isEmpty()) {

                int[] data = queue.poll();
                int cost = data[0];
                int curLocation = data[1];

                if (costs[curLocation] < cost)
                    continue;

                for (int r=1; r <= n; r++) {
                    if (costs[curLocation] + 1 < costs[r] && road[curLocation][r] == 1) {
                        costs[r] = costs[curLocation] + 1;
                        queue.add(new int[] {costs[r], r});
                    }
                }

            }

            for (int r=1; r <= n; r++) {
                answer[k][r-1] = costs[r] == Integer.MAX_VALUE ? -1 : costs[r];
            }
        }

        for (int i =0 ; i < q; i++) {
            for (int j =0 ; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

}