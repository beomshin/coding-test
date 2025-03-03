package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
//        int[] arr = {3, 2, 3, 2, 3};
//        int[] arr = {7, 4, -2, 4, -2, -9};
        int[] arr = {7, -5, -5, -5 , 7, -1, 7};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // Implement your solution here

       if (A.length == 1) return 1;

       int answer = 0;
       int left = 0;
       int right = 1;

       while (left < A.length && right < A.length) {
           if (left > right) {
               right += 2;
           } else if (isRight(A, left, right)) {
               right += 2;
               answer = Math.max(answer, right - left);

               if (right - 1 >=0 && right + 1 < A.length && A[right - 1] == A[right + 1]) {
                   answer = Math.max(answer, answer + 1);
                   System.out.println(left + " " + right);
               }

           } else {
               left += 2;
           }
       }

       return answer;
    }

    public static boolean isRight(int[] arr, int left, int right) {
        int odd = arr[left];
        int even = arr[right];

        for (int i = left; i <= right; i++) {
            if (i % 2 == 0 && arr[i] != odd) {
                return false;
            } else if (i % 2 != 0 && arr[i] != even) {
                return false;
            }
        }

        return true;
    }



}
