package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {

    static int N;
    static int[][] map;
    private static int INF = 200000000; //200,000 * 1,000

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];


        for (int i=0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer = 0;
        int ans1 = 0; // 1 > v1 > v2 > N
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        int ans2 = 0; // 1 > v2 > v1 > N
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        if(ans1 >= INF && ans2 >= INF) answer = -1; //경로가 없는 경우
        else answer = Math.min(ans1, ans2); //경로가 있을 경우 더 작은 값

        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {

        boolean[] visited = new boolean[N+1];
        int[] costs = new int[N+1];
        Arrays.fill(costs, INF);

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            return o1[1] - o2[1];
        }));

        queue.add(new int[]{start, 0});
        costs[start] = 0;

        while (!queue.isEmpty()) {

            int[] val = queue.poll();
            int loc = val[0];
            int cost = val[1];

            if (visited[loc]) continue;
            visited[loc] = true;

            for (int i=1; i <= N; i++) {
                if (map[loc][i] > 0 && costs[i] > cost + map[loc][i]) {
                    costs[i] = cost + map[loc][i];
                    queue.add(new int[]{i, costs[i]});
                }
            }

        }

        return costs[end];
    }
}
