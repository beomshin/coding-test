package binarySearch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/10815
 */
public class Q10815 {

    public static void main(String[] args) {
//        binarySearch();
        hashTable();
    }

    public static void binarySearch() {
        Scanner sc = new Scanner(System.in);
        List<Integer> answer = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> cards = Arrays.stream(sc.nextLine().split(" ")).map(it -> Integer.parseInt(it)).sorted().collect(Collectors.toList());
        int m = Integer.parseInt(sc.nextLine());
        Arrays.stream(sc.nextLine().split(" ")).map(it -> Integer.parseInt(it)).collect(Collectors.toList())
                .forEach(it -> answer.add(isExist(cards,0, n - 1, it) ? 1: 0)); // 구분 카드 리스트 이분 탐색
        System.out.println(answer.stream().map(it -> it + " ").collect(Collectors.joining()).trim());
    }

    public static boolean isExist(List<Integer> cards, int start, int end, int target) {
        if (start > end) return false; // 크기가 역순이 되면 조회 실패

        int mid = (start + end) / 2; // 중간 값

        if (cards.get(mid) == target) { // 성공
            return true;
        } else if (cards.get(mid) < target) { // 시작점을 중간점 + 1
            return isExist(cards, mid + 1, end, target);
        } else { // 종료점을 중간점 - 1
            return isExist(cards, start, mid - 1, target);
        }

    }

    public static void hashTable() {
        Scanner sc = new Scanner(System.in);
        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> cards = Arrays.stream(sc.nextLine().split(" ")).map(it -> Integer.parseInt(it)).collect(Collectors.toList());
        cards.stream().forEach(it -> hashSet.add(it));
        int m = Integer.parseInt(sc.nextLine());
        Arrays.stream(sc.nextLine().split(" ")).map(it -> Integer.parseInt(it)).collect(Collectors.toList())
                .forEach(it -> answer.add(hashSet.contains(it) ? 1 : 0)); // 구분 카드 리스트 이분 탐색
        System.out.println(answer.stream().map(it -> it + " ").collect(Collectors.joining()).trim());
    }


}
