package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5710 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {

            st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            if (A == 0L && B == 0L) break;

            System.out.println(binarySearch(A, B));
        }

    }


    public static long binarySearch(long A, long B) {

       long answer= Long.MAX_VALUE;

       long sum = calWh(A);

       long left = 0;
       long right = sum / 2;

       while (left <= right) {

           long mid = (left + right) / 2;

           long s_price = calCost(mid);
           long n_price = calCost(sum - mid);
           long diff = Math.abs(s_price - n_price);

           if (diff < B) {
               right = mid - 1;
           } else if (diff > B) {
               left = mid +1;
           } else {
               answer = mid;
               break;
           }
       }

        return calCost(answer);
    }


    public static long calWh(long num) {
        if(num <= 200) {
            return num / 2;
        } else if(num <= 29900) {
            return (num - 200) / 3 + 100;
        } else if(num <= 4979900) {
            return (num - 29900) / 5 + 10000;
        } else {
            return (num - 4979900) / 7 + 1000000;
        }
    }

    public static long calCost(long wh) {
        if(wh <= 100) {
            return wh * 2;
        } else if(wh <= 10000) {
            return 200 + (wh - 100) * 3;
        } else if(wh <= 1000000) {
            return 200 + 29700 + (wh - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (wh - 1000000) * 7;
        }
    }
}
