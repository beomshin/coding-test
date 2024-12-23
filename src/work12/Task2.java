package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Task2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L  = Integer.parseInt(st.nextToken()); // 위치
        int N  = Integer.parseInt(st.nextToken()); // 가로등 개수
        int K  = Integer.parseInt(st.nextToken()); // K번째까지 출력

        int[] loc = new int[N];
        int[] light = new int[L + 1];
        int[] dir= {-1, 1};
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1])); // 내림차순

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
            q.add(new int[]{loc[i], 0});
        }

        Arrays.fill(light, L);

        while (!q.isEmpty()) {
            int[] data = q.poll();
            int loc_temp = data[0];
            int light_temp = data[1];

            System.out.println(light_temp);

            K--;
            if (K ==0) {
                break;
            }

            for (int i=0; i < 2; i++) {
                int x1 = loc_temp + dir[i];
                if (x1 >=0 && x1 <= L && light[x1] > light_temp + 1) {
                    light[x1] = light_temp + 1;
                    q.add(new int[]{x1, light_temp + 1});
                }
            }
        }

    }
}
