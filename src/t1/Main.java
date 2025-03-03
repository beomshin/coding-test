package t1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 4, 9);
        List<List<Integer>> answer = subsets(list);


    }



    static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Collections.emptyList());
            return res;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());


        List<List<Integer>> subans = subsets(rest);
        System.out.println(subans);
        List<List<Integer>> subans2 = insertAll(first, subans);

        return concat(subans, subans2);
    }


    static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> sub : subans) {
            List<Integer> newSub = new ArrayList<>();
            newSub.add(first);
            newSub.addAll(sub);
            res.add(newSub);
        }
        return res;
    }

    static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {
        List<List<Integer>> res = new ArrayList<>(subans);
        res.addAll(subans2);
        return res;
    }
}
