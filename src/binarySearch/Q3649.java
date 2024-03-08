package binarySearch;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/3649
 */
public class Q3649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;

        while ((s = br.readLine()) != null) {
            int X = Integer.parseInt(s);
            int N = Integer.parseInt(s);
            int[] block = new int[N];
            for (int i=0; i < N; i++) {
                block[i] = Integer.parseInt(s);
            }

            int size = 10000000 * X;
            Arrays.sort(block);

            boolean flag = false;
            int l1 = 0;
            int l2 = 0;

            for (int i=0; i < N ; ++i) {
                int piece1 = block[i];
                int left = i + 1;
                int right = N - 1;

                while (left <= right) {
                    int piece2 = (left + right) / 2;
                    if (block[piece1] + block[piece2] == size) {
                        if (Math.abs(block[piece1] - block[piece2]) >= Math.abs(block[l1] - block[l2])) {
                            flag = true;
                            l1 = piece1;
                            l2 = piece2;
                        }
                        break;
                    } else if (block[piece1] + block[piece2] < size) {
                        left = piece2 + 1;
                    } else if (block[piece1] + block[piece2] > size) {
                        right = piece2 - 1;
                    }
                }
            }

            if (flag) {
                bw.write("yes " + l1 + " " + l2 + "\n");
            } else {
                bw.write("danger" + "\n");
            }

        }

        bw.close();
    }


    public static boolean binarySearch(int[] block, int start, int end, int target) {
        if (start > end) return false;

        int mid = (start + end) / 2;

        if (block[mid] == target) {
            return true;
        } else if (block[mid] < target) {
            return binarySearch(block, mid + 1, end ,target);
        } else  {
            return binarySearch(block, start, mid - 1, target);
        }
    }
}
