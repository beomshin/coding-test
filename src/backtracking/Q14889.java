package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14889 {

    static int answer = Integer.MAX_VALUE;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        boolean[] team = new boolean[N];

        for (int i=0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(-1, team, N/2);

        System.out.println(answer);
    }

    public static void backtracking(int prev, boolean[] team, int count) {
        if (count == 0) {
            int scoreA = 0;
            int scoreB = 0;

            for (int i=0; i < N; i++) {
                if (team[i]) {
                    scoreA += add(team, team[i], i);
                } else {
                    scoreB += add(team, team[i], i);
                }
            }

            answer = Math.min(answer, Math.abs(scoreA - scoreB));
            return;
        }

        for (int i=prev+1; i < N; i++) {
            team[i] = true;
            backtracking(i, team, count - 1);
            team[i] = false;
        }

    }

    public static int add(boolean[] team, boolean type, int num) {
        int score = 0;
        for (int i=0; i < N; i++) {
            if (team[i] == type) {
                score += map[num][i];
            }
        }
        return score;
    }

}
