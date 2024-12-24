package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Task2 {

    private static int[] dir = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long L  = Long.parseLong(st.nextToken()); // 위치
        int N  = Integer.parseInt(st.nextToken()); // 가로등 개수
        int K  = Integer.parseInt(st.nextToken()); // K번째까지 출력
        HashSet<Long> visited = new HashSet<>();
        PriorityQueue<Long[]> q = new PriorityQueue<>(((o1, o2) -> Math.toIntExact(o1[1] - o2[1]))); // 내림차순

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            q.add(new Long[]{Long.parseLong(st.nextToken()), 0L});
        }

        while (!q.isEmpty()) {
            Long[] t = q.poll();
            long loc_temp = t[0];
            long light_temp = t[1];

            if (!visited.contains(loc_temp)) {
                System.out.println(light_temp);
                visited.add(loc_temp);

                K--;
                if (K ==0) break;

                for (int i=0; i < 2; i++) {
                    long x1 = loc_temp + dir[i];
                    if (x1 >=0 && x1 <= L ) {
                        q.add(new Long[]{x1, light_temp + 1});
                    }
                }
            }

        }

    }
}
