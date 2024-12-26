package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Task11 {

    static class Node {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        public boolean isPut(Integer num) {
            if (stack1.isEmpty()) {
                stack1.push(num);
            } else if (stack1.peek() < num) {
                stack1.push(num);
            }  else if (stack2.isEmpty()) {
                stack2.push(num);
            } else if (stack2.peek() < num) {
                stack2.push(num);
            }  else if (stack3.isEmpty()) {
                stack3.push(num);
            } else if (stack3.peek() < num) {
                stack3.push(num);
            } else if (stack4.isEmpty()) {
                stack4.push(num);
            } else if (stack4.peek() < num) {
                stack4.push(num);
            }  else {
                return false;
            }
            return true;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] table = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        Node root = new Node();

        for (int i = 0; i < N; i++) {
            if (!root.isPut(table[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
