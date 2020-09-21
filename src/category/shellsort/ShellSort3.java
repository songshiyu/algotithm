package category.shellsort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 希尔排序步长优化
 * @create: 2020/9/21 10:47:39
 **/
public class ShellSort3 extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        int h = 1;

        while (h < arr.length) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {

                E tmp = arr[i];
                int j;
                for (j = i; j - h >= 0 && tmp.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = tmp;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        Integer[] copy = Arrays.copyOf(array, array.length);

        AlgorithmHelper.sort(ShellSort2.class, "ShellSort2", copy);
        AlgorithmHelper.sort(ShellSort3.class, "ShellSort3", array);
    }
}
