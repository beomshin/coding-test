package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task18 {

    private static int p, q, a, n, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        backTracking(0, 1, 1, 0);

        System.out.println(ans);
    }

    static void backTracking(int nume, int deno, int start, int cnt) {
        System.out.println(nume + "/" + deno);
        if (deno * p == nume * q) {
            ans++;
            return;
        }

        if (cnt == n) {
            return;
        }

        for (int i = start; i * deno <= a; i++) {
            int nxtNume = deno + nume * i;
            int nxtDeno = deno * i;
            backTracking(nxtNume, nxtDeno, i, cnt + 1);
        }
    }

}
