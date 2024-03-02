package backtracking;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1174
 */
public class Q1174 {

    static HashMap<Integer, String> maps = new HashMap<>();
    static int num = 1;

    static String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static void main(String[] args) {
        backtracking();
    }

    public static void backtracking() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int digit = 1;
        while (digit <= 10) {
            for (int i=0; i < nums.length; i++) {
                createMaps(i, nums[i], digit);
            }
            digit++;
        }
        System.out.println(maps.get(n) == null ? "-1" : maps.get(n));
    }

    public static void createMaps(int idx, String target, int digit) {

        if (target.length() == digit) {
            maps.put(num++, target);
            return;
        }

        for (int i=0; i < idx; i++) {
            createMaps(i, target + nums[i], digit);
        }

    }





}
