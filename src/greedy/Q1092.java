package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1092
 */
public class Q1092 {

    public static void main(String[] args) throws IOException {
        greedy();
    }


    public static void greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> crane = new ArrayList<>();


        for (int i=0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }


        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> weight = new ArrayList<>();

        for (int i=0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            weight.add(n);
        }


        crane.sort(Collections.reverseOrder());
        weight.sort(Collections.reverseOrder());

        if (weight.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!weight.isEmpty()) {

            int idx = 0;
            for (int i=0; i < N;) {
               if (weight.isEmpty() || weight.size() == idx) break;

               if (crane.get(i) >= weight.get(idx)) {
                   i++;
                   weight.remove(idx);
               } else {
                   idx++;
               }
           }

           time++;
        }

        System.out.println(time);
    }

}
