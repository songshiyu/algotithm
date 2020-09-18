package review.sort.bubblesort;

import util.AlgorithmHelper;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description:
 * @create: 2020/9/18 15:35:39
 **/
public class BubbleSort2 extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; ) {

            int lastSwapIndex = 0;
            for (int j = 1; j <= arr.length - 1 - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    AlgorithmHelper.swap(arr, j - 1, j);
                    lastSwapIndex = j;
                }
            }
            i = arr.length - lastSwapIndex;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 5, 7, 1, 6, 8, 2};
        BubbleSort2 bubbleSort2 = new BubbleSort2();
        bubbleSort2.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
