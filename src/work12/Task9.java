package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Task9 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] table = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table);

        int left = 0;
        int right = table.length - 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1) - Math.abs(o2));

        while (left < right) {
            int sum = table[left] + table[right];

            if (sum == 0) {
                System.out.println(0);
                return;
            }
            else if (sum < 0) {
                left++;
            } else {
                right--;
            }

            pq.add(sum);
        }
        System.out.println(pq.peek());

    }


}
