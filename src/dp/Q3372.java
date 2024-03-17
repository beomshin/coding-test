package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3372 {

    static int[][] dir = {
            {0, 1},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        BigInteger[][] dp = new BigInteger[N][N];

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i < N; i++) Arrays.fill(dp[i], new BigInteger("0"));
        dp[0][0] = new BigInteger("1");

        for (int i=0; i < N; i++) {

            for (int j=0; j < N; j++) {
                if (dp[i][j] == null) continue;
                else if (map[i][j] == 0) continue;

                for (int k=0; k < dir.length; k++) {
                    int x = i + (dir[k][0] *  map[i][j]);
                    int y = j + (dir[k][1] *  map[i][j]);


                    if (x >=0 && y >=0 && x < N && y < N ) {
                        dp[x][y] = dp[x][y].add(dp[i][j]);
                    }
                }
            }
        }

        for (int i=0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[N-1][N-1]);


    }


}
