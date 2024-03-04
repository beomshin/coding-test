package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3020
 */
public class Q3020 {

    static int answer = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        binarySearch();
    }


    public static void binarySearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        ArrayList<Integer> up = new ArrayList<>();
        ArrayList<Integer> down = new ArrayList<>();

        for (int i=0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (i%2 ==0) {
                up.add(n);
            } else {
                down.add(n);
            }
        }

        Collections.sort(up);
        Collections.sort(down);

        int answer = Integer.MAX_VALUE;
        int count = 0;

        for (int i=1; i <= H; i ++) {
            int conflict  = binarySearch(up, 0 , N/2, i) + binarySearch(down, 0, N/2, H-i + 1);
            if (conflict < answer) {
                count = 1;
                answer = conflict;
            } else if (conflict == answer) {
                count++;
            }

        }

        System.out.println(answer + " " + count);

    }



    public static int binarySearch(ArrayList<Integer> arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        return arr.size() - end;
    }
}