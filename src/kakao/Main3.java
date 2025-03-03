package kakao;

import java.util.Arrays;
import java.util.HashSet;

public class Main3 {


    public static void main(String[] args) {
//        int[] T = {0, 3, 0, 0, 5, 0, 5};
//        int[] A = {4, 2, 6, 1, 0};
//        int[] T = {0, 0 , 1, 2};
//        int[] A = {1, 2};
        int[] T = {0 , 0 , 0, 0, 2, 3, 3};
        int[] A = {2, 5, 6};
//        int[] T = {0, 0, 1, 1};
//        int[] A = {2};
        System.out.println(solution(T, A));
    }


    public static int solution(int[] T, int[] A) {
        // Implement your solution here
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for (int i=0; i < A.length; i++) {
            int subSkill = A[i];
            set.add(subSkill);

            int topSkill = T[subSkill];

            while (topSkill != 0) {
                set.add(topSkill);

                if (T[topSkill] == 0 || set.contains(T[topSkill])) {
                    break;
                }

                topSkill = T[topSkill];
            }

        }

        return set.size();
    }
}
