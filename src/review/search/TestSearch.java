package review.search;

import review.search.binarysearch.BinarySearchR;
import review.search.linesearch.LineSearch;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @description:
 * @create: 2020/9/15 16:56:37
 **/
public class TestSearch {

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        int target = random.nextInt(n);

        long startTime1 = System.nanoTime();
        int index1 = BinarySearchR.searchR(arr, target);
        long endTime1 = System.nanoTime();
        System.out.println("binarySearch: " + new BigDecimal((endTime1 - startTime1) / 1000000000.0));
        System.out.println(index1);

        long startTime2 = System.nanoTime();
        int index2 = LineSearch.search(arr, target);
        long endTime2 = System.nanoTime();
        System.out.println("lineSearch: " + (endTime2 - startTime2) / 1000000000.0);
        System.out.println(index2);

    }
}
