package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2251 {

    private static HashSet<String> set = new HashSet<>();

    private static PriorityQueue<Integer> answer = new PriorityQueue<>();

    private static int[] max;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        max = new int[]{A, B, C};

        dfs(0, 0, C);

        StringBuffer sb = new StringBuffer();
        while (!answer.isEmpty()) {
            sb.append(answer.poll()).append(" ");
        }


        System.out.println(sb.toString());
    }


    public static void dfs(int A, int B, int C) {

        String val = "" + A + B + C;
        if (set.contains(val)) return;
        set.add(val);

        if (A == 0) {
            answer.add(C);
        }

        if (A != 0) {
            dfs(A - cal(A, B, max[1]), B + cal(A, B, max[1]), C);
            dfs(A - cal(A, C, max[2]), B, C + cal(A, C, max[2]));
        }

        if (B != 0) {
            dfs(A + cal(B, A, max[0]), B - cal(B, A, max[0]), C);
            dfs(A, B - cal(B, C, max[2]) , C + cal(B, C, max[2]));
        }

        if (C != 0) {
            dfs(A + cal(C, A, max[0]), B, C - cal(C, A, max[0]));
            dfs(A, B + cal(C, B, max[1]) , C - cal(C, B, max[1]));
        }

    }

    public static int cal(int A, int B, int max) {
        return Math.min(max - B, A);
    }
}
