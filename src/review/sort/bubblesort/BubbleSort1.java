package review.sort.bubblesort;

import util.AlgorithmHelper;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 冒泡排序复习
 * @create: 2020/9/18 15:25:09
 **/
public class BubbleSort1 extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        //第一层循环是数组中有序对的个数
        for (int i = 0; i < arr.length; i++) {

            //第二层是循环比较
            for (int j = 1; j <= arr.length - i - 1; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    AlgorithmHelper.swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 5, 7, 1, 6, 8, 2};
        BubbleSort1 bubbleSort1 = new BubbleSort1();
        bubbleSort1.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
