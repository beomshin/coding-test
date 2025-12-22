package y26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3167 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] passengers = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            passengers[i][0] = Integer.parseInt(st.nextToken());
            passengers[i][1] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = 0;
        int a = 0;

        int[][] score = new int[2][2];
        int ticketRound = 1;

        for (int i = 0; i < N; i++) {


            int out = passengers[i][0];
            int in = passengers[i][1];

            if (score[0][0] >= out) {
                score[0][0] -= out;
                score[0][1] += in;
            } else {
                int left = out - score[0][0];
                score[0][0] = 0;
                score[0][1] -= left;
                min += left;
                score[0][1] += in;
            }


            if (score[1][1] >= out) {
                score[1][1] -= out;
                max += out;
                score[1][1] += in;
            } else {
                int left = out - score[1][1];
                score[1][1] = 0;
                score[1][0] -= left;
                max += (out - left);
                score[1][1] += in;
            }

            if (ticketRound - 1 == i) {

                score[0][0] += score[0][1]; // 검사
                score[0][1] = 0; // 미검사 수 초기화

                score[1][0] += score[1][1]; // 검사
                score[1][1] = 0; // 미검사 수 초기화

                a++;
                ticketRound = a * K + 1;
            }

        }

        System.out.println(min + " " + max);
    }

}
