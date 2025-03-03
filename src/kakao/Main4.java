package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
//        int[] arr = {3, 2, 3, 2, 3};
//        int[] arr = {7, 4, -2, 4, -2, -9};
        int[] arr = {7, -5, -5, -5 , 7, -1, 7};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // Implement your solution here

        if (A.length == 1) return 1;

        List<Node> odds = new ArrayList<>();
        List<Node> evens = new ArrayList<>();

        int start = 0;
        int num = A[0];

        for (int i = 0; i < A.length ; i += 2) {
            if (num != A[i]) {
                odds.add(new Node(start, i - 2));
                start = i;
                num = A[i];
            }
        }
        odds.add(new Node(start, A.length - 1));


        start = 1;
        num = A[1];

        for (int i = 1; i < A.length ; i += 2) {
            if (num != A[i]) {
                evens.add(new Node(start, i - 2));
                start = i;
                num = A[i];
            }
        }

        if (start == A.length - 2) {
            evens.add(new Node(start, A.length - 2));
        } else {
            evens.add(new Node(start, A.length - 1));
        }

        for (int i= 0 ; i  < odds.size() ; i ++) {
            for (int j = 0 ; j < evens.size() ; j ++) {
                Node odd = odds.get(i);

                if (odd.start == odd.end) continue;




            }
        }

        System.out.println(Arrays.toString(odds.toArray()));
        System.out.println(Arrays.toString(evens.toArray()));


//        return answer;
        return 0;
    }

   static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

       @Override
       public String toString() {
           return "Node{" +
                   "start=" + start +
                   ", end=" + end +
                   '}';
       }
   }



}
