package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10472 {
    static int answer;

    static int[][] dir = {
            {0, 0},
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i < t; i++) {

            int[][] target = new int[3][3];

            for (int j=0; j < 3; j++) {
                String[] arr = br.readLine().split("");
                target[j][0] = arr[0].equals("*") ? 1 : 0;
                target[j][1] = arr[1].equals("*") ? 1 : 0;
                target[j][2] = arr[2].equals("*") ? 1 : 0;
            }

            answer = Integer.MAX_VALUE;
            dfs(target, 0, 0);

            System.out.println(answer);
        }


    }

    public static void dfs(int[][] map, int num, int count) {
        if (num >= 9) {
            if (!isRight(map, 1)) {
                answer = Math.min(count, answer);
            }
            return;
        }

        int x = num / 3;
        int y = num % 3;

        dfs(map, num+1, count);
        dfs(click(map, x, y), num+1, count + 1);
    }


    public static boolean isRight(int[][] target, int num) {
        for (int i=0; i< 3; i++) {
            for (int j=0; j< 3; j++) {
                if (target[i][j] == num) return true;
            }
        }
        return false;
    }


    public static int[][] click(int[][] map, int x, int y) {
        int[][] m2 = new int[3][3];
        for (int i=0; i < 3; i++) {
            m2[i] = Arrays.copyOf(map[i], 3);

        }
        for (int[] d : dir) {
            int x1 = x + d[0];
            int y1 = y + d[1];
            if (x1 >= 0 && y1 >= 0 && x1 < 3 && y1 < 3) {
                m2[x1][y1] = m2[x1][y1] == 1 ? 0 : 1;
            }
        }
        return m2;
    }




}
