package work12;

public class Main {

    public static void main(String[] args) {

    }



    public static int solution(int[] start, int[] dest, int[] limit) {
        // Implement your solution here
        int answer = 0;

        int N = start.length; // 열차 이동 횟수
        int max = 0; // 방문한 가장 높은 역

        int cost = 0;

        for (int i = 0; i < N; i++) {
            int s = start[i];
            int d = dest[i];
            int len = Math.abs(s - d);
            cost += len * 2 + 1;
            max = Math.max(max, s);
            max = Math.max(max, d);
        }

        if (cost > limit[max]) {
            answer = limit[max];
        } else {
            answer = cost;
        }

        return answer;
    }
}
