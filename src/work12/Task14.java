package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task14 {

    private static long victoryHi = 0;
    private static long victoryARS = 0;
    private static long drawHiAndArs = 0;

    private static HashSet<Integer> hiset = new HashSet<>();
    private static HashMap<Integer, Integer> overlap_ars = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] hi = new int[N];
        int[] ars = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            hi[i] = n;
            hiset.add(n);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            ars[i] = n;
            if (hiset.contains(n)) {
                overlap_ars.put(n, overlap_ars.getOrDefault(n, 0) + 1);
            }
        }

        Arrays.sort(hi);
        Arrays.sort(ars);

        for (int i = 0; i < N; i++) {
            int target = hi[i];
            int pin = binarySearch(ars, target);
            victoryHi += pin - overlap_ars.getOrDefault(target, 0);
            victoryARS += ars.length - pin;
            drawHiAndArs += overlap_ars.getOrDefault(target, 0);
        }


        System.out.println(victoryHi + " " + victoryARS + " " + drawHiAndArs);

    }

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }

        }

        return left;
    }

}
