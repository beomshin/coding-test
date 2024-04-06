package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1759 {

    static int L, C;
    static List<String> ENGLISH = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u","v", "w", "x", "y", "z");

    static List<String> ENGLISH2 = Arrays.asList("a", "e", "i", "o", "u");
    static List<String> ENGLISH3 = Arrays.asList("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t","v", "w", "x", "y", "z");

    static PriorityQueue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String[] words = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < C; i++) {
            words[i] = st.nextToken();
        }


        dfs(words, new String[L], 0, new boolean[C]);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void dfs(String[] words, String[] word, int idx, boolean[] visited) {
        if (idx == L) {
            String str = String.join("", word);
            if (isTrue(str)) {
                queue.add(str);
            }
            return;
        }

        for (int i=0; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (idx >= 1) {
                    String s1 = word[idx - 1];
                    String s2 = words[i];
                    if (ENGLISH.indexOf(s1) < ENGLISH.indexOf(s2)) { // 정렬 순서 지키기
                        word[idx] = words[i];
                    } else {
                        visited[i] = false;
                        continue;
                    }
                } else {
                    word[idx] = words[i]; // 처음 경우
                }

                dfs(words, word, idx + 1, visited);
                word[idx] = null;
                visited[i] = false;
            }
        }

    }

    public static boolean isTrue(String str) { // 자음, 모음 제한 개수 처리
        int n1 =0;
        int n2 = 0;
        for (int i=0; i < ENGLISH2.size(); i++) {
            if (str.contains(ENGLISH2.get(i))) {
                n1++;
            }
        }
        for (int i=0; i < ENGLISH3.size(); i++) {
            if (str.contains(ENGLISH3.get(i))) {
                n2++;
            }
        }
        return n1 >= 1 && n2 >= 2;
    }

}
