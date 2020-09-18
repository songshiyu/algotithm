package category.shellsort;

import category.bubblseort.BubbleSort;
import review.sort.insertsort.InsertSort;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 希尔排序
 * @create: 2020/9/18 09:39:38
 **/
public class ShellSort extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        int h = arr.length / 2;

        while (h >= 1) {

            for (int start = 0; start < h; start++) {

                for (int i = start + h; i < arr.length; i += h) {

                    E tmp = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && tmp.compareTo(arr[j - h]) < 0; j -= h) {
                        arr[j] = arr[j - h];
                    }
                    arr[j] = tmp;
                }
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        Integer[] copy = Arrays.copyOf(array, array.length);

        AlgorithmHelper.sort(ShellSort.class, "ShellSort", array);
        AlgorithmHelper.sort(InsertSort.class,"InsertSort",copy);
    }
}
