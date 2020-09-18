package review.sort.insertsort;

import util.AlgorithmHelper;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description:
 * @create: 2020/9/15 17:24:42
 **/
public class InsertSort extends BaseAlgotithm {

    /**
     * 这种方式，一个元素可能会移动多次，会有不必要的时间消耗
     * */
    /*@Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        */

    /**
     * 元素i之前的元素都是有序的，i之后的元素都是无序的
     *//*
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    AlgorithmHelper.swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }*/


    /**
     * 没有交换元素的过程，全程通过平移元素进行排序
     */
    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j;
            E tmp = arr[i];
            for (j = i; j - 1 >= 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {3, 2, 4, 6, 7, 1, 9, 5, 8};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);

        Arrays.stream(arr).forEach(System.out::print);
    }
}
