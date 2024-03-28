package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1253 {

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashMap<Long, Boolean> visited =  new HashMap<>();

        long[] nums = new long[N];
        int answer= 0;

        st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int i=0 ; i < N; i++) {

            long num = nums[i];

            int left = 0;
            int right = N-1;

            while (left < right) {

                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }

                long sum = nums[left] + nums[right];

                if (sum == num) {
                    answer++;
                    break;
                } else if (sum > num) {
                    right--;
                } else {
                    left++;
                }

            }


        }

        System.out.println(answer);
    }


}
