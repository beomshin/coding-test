package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Task17 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long cur = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int loc = Integer.parseInt(st.nextToken());

                if (cur > loc) {
                    left.add(loc);
                } else {
                    right.add(loc);
                }

            } else if (type == 2) {

                while (!left.isEmpty() || !right.isEmpty()) {


                    if (!left.isEmpty() && !right.isEmpty()) {

                        long len1 = Math.abs(cur - left.peek());
                        long len2 = Math.abs(right.peek() - cur);

                        if (len1 == len2) {
                            cur = left.poll();
                            ans += len1;
                        } else if (len1 < len2) {
                            cur = left.poll();
                            ans += len1;
                        } else {
                            cur = right.poll();
                            ans += len2;
                        }

                    } else if (left.isEmpty() && !right.isEmpty()) {
                        ans += Math.abs(cur - right.peek());
                        cur = right.poll();
                    } else if (right.isEmpty() && !left.isEmpty()) {
                        ans += Math.abs(cur - left.peek());
                        cur = left.poll();
                    }

                }

            }


        }

        System.out.println(ans);

    }
}
