package category.quicksort;

import category.mergesort.MergeSort;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 快速排序之三路快排 将数组分为大于标定点，等于标定点，小于标定点三种情况
 * @create: 2020/8/24 08:31:27
 **/
public class QuickSortThreeWays extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    public <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {

        if (l >= r) {
            return;
        }


        //三路排序的partition过程开始
        int index = random.nextInt(r - l + 1);
        AlgorithmHelper.swap(arr, l, index + l);

        //arr[l + 1,lt] < v  arr[lt + 1,i - 1] == v  arr[gt,r] > v
        int lt = l, i = l + 1, gt = r + 1;

        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                AlgorithmHelper.swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                AlgorithmHelper.swap(arr, gt, i);
            } else {
                i++;
            }
        }
        AlgorithmHelper.swap(arr, l, lt);
        //三路排序的partition过程结束

        sort(arr, l, lt - 1, random);
        sort(arr, gt, r, random);
    }

    public static void main(String[] args) {
        int capacity = 10000;
        Integer[] orderArray = ArrayGenerator.generatorArray(capacity);
        Integer[] twoOrderArray = Arrays.copyOf(orderArray, orderArray.length);
        Integer[] threeOrderArray = Arrays.copyOf(orderArray, orderArray.length);

        System.out.println("----------------------有序的数组-----------------------------");
        AlgorithmHelper.sort(UpgradeQuickSort.class, "UpgradeQuickSort", orderArray);
        AlgorithmHelper.sort(DoubleWayQuickSort.class, "DoubleWayQuickSort", twoOrderArray);
        AlgorithmHelper.sort(QuickSortThreeWays.class, "QuickSortThreeWays", threeOrderArray);


        System.out.println("----------------------无序的数组-----------------------------");
        Integer[] randomArray = ArrayGenerator.generatorRandArray(capacity, capacity);
        Integer[] twoRandomArray = Arrays.copyOf(randomArray, randomArray.length);
        Integer[] threeRandomArray = Arrays.copyOf(randomArray, randomArray.length);

        AlgorithmHelper.sort(UpgradeQuickSort.class, "UpgradeQuickSort", randomArray);
        AlgorithmHelper.sort(DoubleWayQuickSort.class, "DoubleWayQuickSort", twoRandomArray);
        AlgorithmHelper.sort(QuickSortThreeWays.class, "QuickSortThreeWays", threeRandomArray);

        System.out.println("----------------------有大量相同元素的数组-----------------------------");
        Integer[] sameArray = ArrayGenerator.generatorRandArray(capacity, 1);
        Integer[] twoSameArray = Arrays.copyOf(sameArray,sameArray.length);
        Integer[] threeSameArray = Arrays.copyOf(sameArray,sameArray.length);

        AlgorithmHelper.sort(UpgradeQuickSort.class,"UpgradeQuickSort",sameArray);
        AlgorithmHelper.sort(DoubleWayQuickSort.class, "DoubleWayQuickSort", twoSameArray);
        AlgorithmHelper.sort(QuickSortThreeWays.class, "QuickSortThreeWays", threeSameArray);
    }
}
