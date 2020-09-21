package category.shellsort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

/**
 * @description: 修改希尔排序过程中，循环的次数，但是对希尔排序的性能没有提升
 * @create: 2020/9/21 08:44:01
 **/
public class ShellSort2 extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        int h = arr.length / 2;

        while (h >= 1) {

            for (int i = h; i < arr.length; i++) {
                E tmp = arr[i];
                int j;

                for (j = i; j - h >= 0 && tmp.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = tmp;
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        AlgorithmHelper.sort(ShellSort2.class, "ShellSort2", array);
    }
}
