package work12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3 {

    private static HashSet<String> isExist = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        HashMap<String, int[]> places = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (name.length() > 10) continue;
            if (place.length() > 20) continue;

            if (isExist.contains(name)) continue;
            isExist.add(name);

            int[] timeTable = places.getOrDefault(place, new int[50001]);
            for (int j = start; j < end; j++) {
                timeTable[j]++;
            }

            places.put(place, timeTable);
        }

        Iterator<String> iterator = places.keySet().iterator();

        int max = 0;
        HashMap<String, List<Integer>> answer = new HashMap<>();

        while (iterator.hasNext()) {
            String place = iterator.next();
            int[] timeTable = places.get(place);

            int max_temp = 0;
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < timeTable.length; i++) {
                if (max_temp < timeTable[i]) {
                    list.clear();
                    list.add(i);
                    max_temp = timeTable[i];
                } else if (max_temp == timeTable[i]) {
                    list.add(i);
                }
            }


            if (max_temp > max) {
                answer.clear();
                answer.put(place, list);
                max = max_temp;
            } else if (max_temp == max) {
                answer.put(place, list);
            }

        }

        Iterator<String> iterator2 = answer.keySet().stream().sorted().iterator();
        String place = iterator2.next();
        List<Integer> list = answer.get(place);
        int start = list.get(0);
        int end = list.get(0) + 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - 1 == list.get(i - 1)) {
                end = list.get(i) + 1;
            } else {
                break;
            }
        }
        System.out.println(place + " " + start + " " + end);
    }
}
