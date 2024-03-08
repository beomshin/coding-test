package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9024
 */
public class Q9024 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int k=0; k < t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i=0 ;i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);
            System.out.println(cal(nums, K));

        }
    }

    public static int cal(int[] nums, int K) {


            int count = 0;
            int min = Integer.MAX_VALUE;

            for (int i=0; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left <= right) {

                    int mid = (left + right) / 2;

                    if (Math.abs(K - (nums[i] + nums[mid])) < min) {
                        count = 1;
                        min = Math.abs(K - (nums[i] + nums[mid]));
                    } else if (Math.abs(K - (nums[i] + nums[mid])) == min) {
                        count++;
                    }

                   if (K > (nums[i] + nums[mid])) {
                        left = mid + 1;
                    } else if (K < (nums[i] + nums[mid]))  {
                        right = mid - 1;
                    } else {
                       break;
                   }
                }
            }


        return count;
    }


}
