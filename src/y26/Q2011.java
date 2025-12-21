package y26;


import java.io.IOException;
import java.util.Scanner;

public class Q2011 {


    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] cipher = sc.next().strip().split("");

        int[] words  = new int[cipher.length+1];
        words[0] = 1;

        for (int i = 1; i < words.length; i++) {

            int num = Integer.parseInt(cipher[i-1]);

            if (num >= 1 && num <= 9) {
                words[i] += words[i-1];
                words[i] %= 1000000;
            }

            if (i == 1) continue;

            int num2 = Integer.parseInt(cipher[i-2] + cipher[i-1]);

            if (num2 >= 10 && num2 <= 26) {
                words[i] +=  words[i-2];
                words[i] %= 1000000;
            }
        }

        System.out.println(words[cipher.length]);

    }


}
