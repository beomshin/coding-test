package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/13700
 */
public class Q13700 {


    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마포구 건물수
        int S = Integer.parseInt(st.nextToken()) - 1; // 금은방 (시작점)
        int D = Integer.parseInt(st.nextToken()) - 1; // 집 (종점)
        int F = Integer.parseInt(st.nextToken()); // 오른쪽 이동 수
        int B = Integer.parseInt(st.nextToken()); // 왼쪽 이동 수
        int K = Integer.parseInt(st.nextToken()); // 경찰서 개수
        HashSet<Integer> police = new HashSet<>();

        if (K > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i=0; i < K; i++) {
                police.add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        int[] visited = new int[N];
        Arrays.fill(visited, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1])
                return Math.abs(D - o1[0]) - Math.abs(D - o2[0]);
            return o2[1] - o1[1];
        }));

        queue.add(new int[]{S, 0});

        while (!queue.isEmpty()) {

            int[] val = queue.poll();
            int loc = val[0];
            int cnt = val[1];

            visited[loc] = Math.min(cnt, visited[loc]);

            if (loc == D) break;

            if (loc + F < N && visited[loc + F] > cnt + 1 && !police.contains(loc + F)) {
                queue.add(new int[]{loc + F, cnt+1});
            }

            if (loc - B >= 0 && visited[loc - B] > cnt + 1 && !police.contains(loc - B)) {
                queue.add(new int[]{loc - B, cnt+1});
            }

        }

        System.out.println(visited[D] == Integer.MAX_VALUE ? "BUG FOUND" : visited[D]);

    }

}
