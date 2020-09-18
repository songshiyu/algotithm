package review.sort.quickSort;

import util.AlgorithmHelper;
import util.BaseAlgotithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 三路快排
 * @create: 2020/9/18 16:56:22
 **/
public class QuickSort3 extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {

        if (l >= r){
            return;
        }

        int inedx = random.nextInt(r - l + 1) + l;
        AlgorithmHelper.swap(arr, l, inedx);

        //三路快排开始
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {

            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                AlgorithmHelper.swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                AlgorithmHelper.swap(arr, i, gt);
            } else {
                i++;
            }
        }
        AlgorithmHelper.swap(arr, l, lt);
        //三路快排结束

        sort(arr, l, lt - 1, random);
        sort(arr, gt, r, random);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 6, 7, 2, 4, 87, 42, 1, 9, 12, 432, 65};
        QuickSort3 quickSort3 = new QuickSort3();
        quickSort3.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
