package category.quicksort;

import category.mergesort.MergeSort;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 最初版快速排序，会有问题：当arr是一个有序数组时，时间复杂度为O(n^2),会有可能造成栈溢出
 * @create: 2020/8/21 09:31:23
 **/
public class QuickSort extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int partition = partition(arr, l, r);
        sort(arr, l, partition - 1);
        sort(arr, partition + 1, r);
    }

    /**
     * 原地排序，选出一个基准位置j，j的左侧都比j小，j的右侧都比j大
     */
    public <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        int j = l;
        //arr[l + 1,j] < v, arr[j + 1,i] > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                AlgorithmHelper.swap(arr, i, j);
            }
        }
        AlgorithmHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int capacity = 1000000;
        Integer[] array = ArrayGenerator.generatorArray(capacity);
        //Integer[] array = ArrayGenerator.generatorRandArray(capacity, capacity);
        Integer[] array2 = Arrays.copyOf(array, array.length);

        AlgorithmHelper.sort(MergeSort.class,"MergeSort",array2);
        AlgorithmHelper.sort(QuickSort.class,"QuickSort",array);
    }
}
