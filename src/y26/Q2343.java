package y26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2343 {


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lecture = new  int[N];

        st =  new  StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            lecture[i] = Integer.parseInt(st.nextToken());
        }


        int left = 1;
        int right = Arrays.stream(lecture).sum();
        int answer = 1000000000;
        int min = Arrays.stream(lecture).max().getAsInt();

        while (left <= right){

            int mid = (left + right) / 2;

            int blueray = 0;
            int ans = 0;

            for(int i = 0; i < N; i++){

                if (i == N-1) {

                    if (ans + lecture[i] <= mid){
                        blueray++;
                    } else if (lecture[i] <= mid) {
                        blueray += 2;
                    }

                } else if (ans + lecture[i] > mid){
                    blueray++;
                    ans = lecture[i];

                } else {
                    ans += lecture[i];
                }
            }

            if (blueray <= M){
                answer = Math.min(answer, mid);
                right = mid - 1;
            }  else {
                left = mid + 1;
            }

        }

        System.out.println(Math.max(answer, min));

    }

}