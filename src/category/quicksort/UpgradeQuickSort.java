package category.quicksort;

import category.mergesort.MergeSort;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author songshiyu
 * @description 快速排序第二版：解决第一版快速排序中，对有序数组进行排序时，可能会出现的栈溢出问题
 *                 问题2：当数组中有大量相同元素的时，会可能出现栈溢出或者会消耗很长时间。
 * @date 2020/8/22 11:06
 **/
public class UpgradeQuickSort extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int partition = partition(arr, l, r, random);
        sort(arr, l, partition - 1, random);
        sort(arr, partition + 1, r, random);
    }

    private <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        /**
         * 此处添加一个随机数，随机选取一个[l,r]区间的索引,为了防止有序数组中，每个递归中第一个元素永远是最小的，造成的时间复杂度为O(N^2)
         * */
        int index = random.nextInt(r - l + 1);
        AlgorithmHelper.swap(arr, l, index + l);

        /**
         * arr[l + 1,j] < v   arr[j+1,i] > v
         * */
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                AlgorithmHelper.swap(arr, i, j);
            }
        }
        AlgorithmHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int capacity = 10000;
        Integer[] orderArray = ArrayGenerator.generatorArray(capacity);
        Integer[] copyOrderArray = Arrays.copyOf(orderArray, orderArray.length);

        System.out.println("----------------------有序的数组-----------------------------");
        AlgorithmHelper.sort(UpgradeQuickSort.class, "UpgradeQuickSort", orderArray);
        AlgorithmHelper.sort(MergeSort.class, "MergeSort", copyOrderArray);

        System.out.println("----------------------无序的数组-----------------------------");
        Integer[] randomArray = ArrayGenerator.generatorRandArray(capacity, capacity);
        Integer[] copyRandomArray = Arrays.copyOf(randomArray, randomArray.length);

        AlgorithmHelper.sort(UpgradeQuickSort.class, "UpgradeQuickSort", randomArray);
        AlgorithmHelper.sort(MergeSort.class, "MergeSort", copyRandomArray);

        System.out.println("----------------------有大量相同元素的数组-----------------------------");
        Integer[] sameArray = ArrayGenerator.generatorRandArray(capacity, 1);
        Integer[] copySameArray = Arrays.copyOf(sameArray,sameArray.length);
        AlgorithmHelper.sort(UpgradeQuickSort.class,"UpgradeQuickSort",sameArray);
        AlgorithmHelper.sort(MergeSort.class,"MergeSort",copySameArray);
    }
}
