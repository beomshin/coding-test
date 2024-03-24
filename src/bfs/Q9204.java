package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9204 {


    static String[] e = {"A", "B", "C", "D", "E", "F", "G", "H"};
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int[][] dir = {
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
    };

    public static void main(String[] args) throws IOException {
        solution();
    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i=0; i < e.length; i++) {
            hashMap.put(e[i], i);
        }

        for (int i=0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            List<int[]> start = new LinkedList<>();

            int[] a1 = {hashMap.get(st.nextToken()), Integer.parseInt(st.nextToken()) - 1};
            int[] target = {hashMap.get(st.nextToken()), Integer.parseInt(st.nextToken()) - 1};
            start.add(a1);

            String answer = bfs(start, target, new boolean[8][8]);
            System.out.println(answer);
        }


    }

    public static String bfs(List<int[]> start, int[] target, boolean[][] visited) {

        StringBuffer sb = new StringBuffer();
        Queue<List<int[]>> queue = new LinkedList<>();

        queue.add(start);

        List<int[]> answer=  null;

        while (!queue.isEmpty()){

            List<int[]> track = queue.poll();
            int[] last = track.get(track.size() - 1);
            visited[last[0]][last[1]] = true;

            if (last[0] == target[0] && last[1] == target[1]) {
                answer = track;
                break;
            } else if (track.size() == 5) {
                continue;
            }


            for (int i=0; i < 8; i++) {
                for (int j=0; j < dir.length; j++) {
                    int x = last[0] + (dir[j][0] * i);
                    int y = last[1] + (dir[j][1] * i);
                    if (isTrue(x, y, visited)) {
                        List<int[]> copy = new LinkedList<>(track);
                        int[] a = {x, y};
                        copy.add(a);
                        queue.add(copy);
                    }
                }
            }

        }

        if (answer == null) {
            sb.append("Impossible");
        } else {
            sb.append(answer.size() - 1).append(" ");
            for (int i=0; i < answer.size(); i++) {
                int[] v = answer.get(i);
                sb.append(e[v[0]]).append(" ");
                sb.append(v[1] + 1).append(" ");
            }
        }

        return sb.toString();
    }

    public static boolean isTrue(int x, int y, boolean[][] vistied) {
        return x >=0 && y >= 0 && x < 8 && y < 8 && !vistied[x][y];
    }

}
