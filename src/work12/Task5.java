package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task5 {

    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int max = nums[nums.length - 1];
        HashSet<Integer> twoNumsSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (max > nums[j] + nums[i]) {
                    twoNumsSet.add(nums[j] + nums[i]);
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                int result = nums[i] - nums[j];
                if (twoNumsSet.contains(result)) {
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }

}
