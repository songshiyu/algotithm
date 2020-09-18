package review.sort.quickSort;

import util.AlgorithmHelper;
import util.BaseAlgotithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 单路快排
 * @create: 2020/9/18 15:58:05
 **/
public class QuickSort1 extends BaseAlgotithm {

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

        int index = random.nextInt(r - l + 1) + l;
        AlgorithmHelper.swap(arr, index, l);

        int j = l;
        for (int i = l; i <= r; i++) {
            //比arr[l]大的元素全部放在l的右边，比arr[l]小的元素全部放在l的左边
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                AlgorithmHelper.swap(arr, i, j);
            }
        }
        AlgorithmHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 6, 7, 2, 4, 87, 42, 1, 9, 12, 432, 65};
        QuickSort1 quickSort1 = new QuickSort1();
        quickSort1.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
