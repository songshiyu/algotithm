package category.quicksort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author songshiyu
 * @description 快速排序第三版：双路快速排序，可以解决大部分情况，如数组中有大量相同元素
 * @date 2020/8/23 10:21
 **/
public class DoubleWayQuickSort extends BaseAlgotithm {

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

        int index = random.nextInt(r - l + 1);
        AlgorithmHelper.swap(arr, l, index + l);

        int i = l + 1, j = r;

        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            AlgorithmHelper.swap(arr, i, j);
            i++;
            j--;
        }

        AlgorithmHelper.swap(arr, l, j);

        return j;
    }

    public static void main(String[] args) {
        int capacity = 1000000;
        Integer[] orderArray = ArrayGenerator.generatorArray(capacity);
        Integer[] copyOrderArray = Arrays.copyOf(orderArray, orderArray.length);

        System.out.println("----------------------有序的数组-----------------------------");
        AlgorithmHelper.sort(UpgradeQuickSort.class, "UpgradeQuickSort", copyOrderArray);
        AlgorithmHelper.sort(DoubleWayQuickSort.class, "DoubleWayQuickSort", orderArray);

        System.out.println("----------------------无序的数组-----------------------------");
        Integer[] randomArray = ArrayGenerator.generatorRandArray(capacity, capacity);
        Integer[] copyRandomArray = Arrays.copyOf(randomArray, randomArray.length);

        AlgorithmHelper.sort(UpgradeQuickSort.class, "UpgradeQuickSort", randomArray);
        AlgorithmHelper.sort(DoubleWayQuickSort.class, "DoubleWayQuickSort", copyRandomArray);

        System.out.println("----------------------有大量相同元素的数组-----------------------------");
        Integer[] sameArray = ArrayGenerator.generatorRandArray(capacity, 1);
        Integer[] copySameArray = Arrays.copyOf(sameArray, sameArray.length);

        AlgorithmHelper.sort(DoubleWayQuickSort.class, "DoubleWayQuickSort", copySameArray);
    }
}
