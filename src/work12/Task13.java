package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task13 {

    private static int n, m, a, b;
    private static int blackToWhite = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken()); // 흰 -> 검
        b = Integer.parseInt(st.nextToken()); // 검 -> 흰

        String[][] table = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                table[i][j] = arr[j];
            }
        }

        int len = Math.min(n, m);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j].equals("#")) {
                    blackToWhite += b;
                }
            }
        }

        for (int i = 1; i <= len; i++) {
            if (i % 3 == 0) {
                int result = cal(table, i);
                if (result >= 0) {
                    ans = Math.min(ans, result);
                }
            }
        }

        System.out.println(ans);

    }

    public static int cal(String[][] table, int len) {
        int result = Integer.MAX_VALUE;
        int gap = len / 3;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x1 = i + len - 1;
                int y1 = j + len - 1;
                if (x1 < n && y1 < m) {
                    int sum = blackToWhite;

                    for (int k = i; k <= x1; k++) {
                        for (int l = j; l <= y1; l++) {

                            if (k < i + gap) {
                                if (table[k][l].equals("#")) {
                                    sum -= b;
                                } else {
                                    sum += a;
                                }
                            } else if(k < i + (gap * 2)) {
                                if (l < j + gap) {
                                    if (table[k][l].equals("#")) {
                                        sum -= b;
                                    } else {
                                        sum += a;
                                    }
                                }
                            } else if(k < i + (gap * 3)) {
                                if (table[k][l].equals("#")) {
                                    sum -= b;
                                } else {
                                    sum += a;
                                }
                            }

                        }
                    }

                    result = Math.min(result, sum);

                }
            }
        }

        return result;
    }


}
