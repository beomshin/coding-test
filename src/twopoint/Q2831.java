package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2831 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String[] boy = br.readLine().split(" ");
        String[] girl = br.readLine().split(" ");

        ArrayList<Integer> boy1 = new ArrayList<Integer>();
        ArrayList<Integer> boy2 = new ArrayList<Integer>();
        ArrayList<Integer> girl1 = new ArrayList<Integer>();
        ArrayList<Integer> girl2 = new ArrayList<Integer>();

        for (int i=0; i < N; i++) {
            int n = Integer.parseInt(boy[i]);
            if (n > 0) {
                boy1.add(n); // 자신보다 큰 사람 좋아함
            } else if (n < 0) {
                boy2.add(n * -1); // 자신보다 작은 사람 좋아함
            }

            n = Integer.parseInt(girl[i]);
            if (n > 0) {
                girl1.add(n); // 자신보다 큰 사람 좋아함
            } else if (n < 0) {
                girl2.add(n * -1); // 자신 보다 작은 사람 좋아함
            }
        }

        Collections.sort(boy1);
        Collections.sort(boy2);
        Collections.sort(girl1);
        Collections.sort(girl2);

        int answer = pair(girl2, boy1) + pair(boy2, girl1);

        System.out.println(answer);
    }


    public static int pair(List<Integer> taller, List<Integer>  shorter) {
        int result = 0;

        for (int i=0, j=0; i < taller.size() && j < shorter.size();) {

            int t = taller.get(i);
            int s = shorter.get(j);

            if (t <= s) { // 커야하는 사람이 작은 경우 taller 인덱스를 증가시킨다.
                i++;
                continue;
            }

            i++;
            j++;
            result++;
        }

        return result;
    }
}
