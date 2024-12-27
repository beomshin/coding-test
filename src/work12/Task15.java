package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task15 {

    static class Node {
        int x, y;
        int beer;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int beer) {
            this.x = x;
            this.y = y;
            this.beer = beer;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y && beer == node.beer;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, beer);
        }

        public boolean isMatch(Node node) {
            return Math.abs(x - node.x) + Math.abs(y - node.y) <= beer * 50;
        }

        public boolean isMarket(Node node) {
            return x == node.x && y == node.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Node root = new Node(x, y, 20);

            Node[] markets = new Node[count];

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                markets[j] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 20);
            }

            st = new StringTokenizer(br.readLine());
            Node target = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 20);

            boolean flag = bfs(root, markets, target);

            if (flag) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }

    }

    public static boolean bfs(Node root, Node[] markets, Node target) {
        HashSet<Node> visited = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.isMatch(target)) {
                return true;
            } else if (visited.contains(cur)) {
                continue;
            }

            visited.add(cur);

            for (int i=0; i < markets.length; i++) {
                if (cur.isMatch(markets[i])) {
                    q.add(markets[i]);
                }
            }

        }

        return false;
    }
}
