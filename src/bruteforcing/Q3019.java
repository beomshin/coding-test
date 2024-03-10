package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3019
 */
public class Q3019 {

    static int[][][] blocks = {
            {
                    {0},
                    {0, 0, 0, 0}

            },
            {
                    {0, 0}
            },
            {
                    {0, 0, 1},
                    {0, -1}
            },
            {
                    {0,-1,-1},
                    {0, 1}
            },
            {
                    {0,0,0},
                    {0, 1},
                    {0, -1, 0},
                    {0, -1}
            },
            {
                    {0, 0, 0},
                    {0, 0},
                    {0,1 ,1},
                    {0,-3}
            },
            {
                    {0, 0, 0},
                    {0, 3},
                    {0, 0, -1},
                    {0, 0}
            }
    };


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] height = new int[C];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < C; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int[][] validate = blocks[P-1];

        for (int i=0; i < validate.length; i++) {
            int[] vcase = validate[i];

            for (int w=0; w < C; w++) {
                int max = w + vcase.length - 1;

                if (max >= C) {
                    break;
                }

                int h = height[w];
                boolean flag = true;

                for (int k=0; k < vcase.length; k++) {
                    if (height[w+k] != h + vcase[k]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sum++;
                }
            }

        }

        System.out.println(sum);
    }



}
