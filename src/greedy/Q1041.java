package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1041 {

    public static void main(String[] args) throws IOException {
        greedy();
    }

    public static void greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long[] nums = new long[6];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            Arrays.sort(nums);
            System.out.println(nums[0] + nums[1]+ nums[2]+ nums[3]+ nums[4]);
            return;
        }

        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;
        long min3 = 0;

        for (int i=0; i < nums.length; i++) {
            if (nums[i] < min1) min1 = nums[i];
        }

        for (int i=0; i < nums.length; i++) {
            for (int j=0 ; j < nums.length; j++) {
                if (i != j && i+j != 5) {
                    if (min2 > nums[i] + nums[j]) min2 = nums[i] + nums[j];
                }
            }
        }

        for (int i=0; i < nums.length/2; i++) {
            min3 += Math.min(nums[i], nums[5-i]);
        }

        long answer = 0;
        answer += (5 * n * n + (-16) * n + 12) * min1;
        answer += (4 * (2 * n - 3)) * min2;
        answer += min3 * 4;
        System.out.println(answer);
    }
}
