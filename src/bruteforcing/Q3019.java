package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3019 {

    static int len = 0;
    static int[][][] blocks = {
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {-1, 0}, {-1, 1}, {-1, 2}},
    };


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[][] arr = new int[C][C];
        len = C;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < C; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j=0; j < n; j++ ) {
                arr[j][i] = 1;
            }
        }

        int sum = 0;
        int[][] block = blocks[P-1];

        for (int w=0 ; w < C; w++) {
            for (int h=0 ; h < C; h++) {
                int num = arr[h][w];
                if (num > 0) continue;

                for (int i=0; i < 8; i++) {

                    if (isFloor(block, arr, h , w)) {
                        sum++;
                    }

                    if (i == 3) {
                        block = rotation(block);
                        block = reverse(block);
                    }
                }

                block = rotation(block);
                block = reverse(block);
                break;
            }
        }

        System.out.println(sum);
    }

    public static boolean isFloor(int[][] block, int[][] map, int h, int w) {
        for (int i=0; i < block.length; i ++) {
            int x = h + block[i][0];
            int y = w + block[i][1];
            if (x < 0 || y < 0 || x >= len || y >= len) {
                return false;
            }
            else if (map[x][y] > 0) {
                return false;
            }
            if (y - 1 < 0 ) continue;
            else if (map[x][y-1] == 0) {
                boolean flag = false;
                for (int j=0; j < block.length; j++) {
                    if (block[j][1] < block[i][1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }

        }




        return true;
    }

    public static int[][] rotation(int[][] dir) {
        int[][] new_dir = new int[4][2];
        for (int i=0; i < 4; i++) {
            new_dir[i][0] = dir[i][1] * -1;
            new_dir[i][1] = dir[i][0];
        }
        return new_dir;
    }

    public static int[][] reverse(int[][] dir) {
        int[][] new_dir = new int[4][2];
        for (int i=0; i < 4; i++) {
            new_dir[i][0] = dir[i][0];
            new_dir[i][1] = dir[i][1] * -1;
        }
        return new_dir;
    }


}
