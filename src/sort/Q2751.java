package sort;

import java.io.*;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2751
 */
public class Q2751 {

    public static void main(String[] args) throws IOException {
        sort();
//        sort2();
    }

    public static void sort() throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i=0 ; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        Iterator<Integer> iterator = priorityQueue.iterator();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (iterator.hasNext()) {
            bw.write(priorityQueue.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void sort2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for (int i=0 ; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        quickSort(nums, 0, nums.length - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i < n; i++) {
            bw.write(nums[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void quickSort(int[] nums, int L, int R) {

        int left = L, right = R;
        int pivot = nums[(L + R) / 2];
        int temp;

        while (left <= right) {
            while (nums[left] < pivot) left++;
            while (nums[right] > pivot) right--;

            if (left <= right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }

        if (L < right) {
            quickSort(nums, L, right);
        }

        if (left < R) {
            quickSort(nums, left, R);
        }

    }
}
