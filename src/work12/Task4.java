package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Task4 {

    private static PriorityQueue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());


            isTrue(K-1, "", 0);

            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            System.out.println();
        }

    }


    public static void isTrue(int deep, String  operations, int idx) {
        if (deep == 0) {
            String[] p = operations.split(",");
            int num = 1;
            int sum = p[0].equals(" ") ? 0 : 1;
            int tmp = p[0].equals(" ") ? 1 : 0;
            boolean flag = true;

            for (int i = 0; i < p.length; i++) {
                num++;
                if (p[i].equals("+")) {
                    sum += flag ? tmp : -tmp;
                    flag = true;
                    tmp = num;
                } else if (p[i].equals("-")) {
                    sum += flag ? tmp : -tmp;
                    flag = false;
                    tmp = num;
                } else if (p[i].equals(" ")) {
                    tmp *= 10;
                    tmp += num;
                }
            }

            sum += flag ? tmp : -tmp;

            if (sum == 0) {
                int num2= 1;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < p.length; i++) {
                    sb.append(num2++).append(p[i]);
                }
                sb.append(num2);
                queue.add(sb.toString());
            }
            return;
        }


        isTrue(deep - 1 , operations + "+," , idx + 1);
        isTrue(deep - 1 , operations + " ," , idx + 1);
        isTrue(deep - 1 , operations + "-," , idx + 1);

    }
}
