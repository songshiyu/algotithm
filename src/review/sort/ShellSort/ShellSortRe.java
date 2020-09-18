package review.sort.ShellSort;

import util.AlgorithmHelper;
import util.BaseAlgotithm;

/**
 * @description: 复习希尔排序
 * @create: 2020/9/18 11:08:08
 **/
public class ShellSortRe extends BaseAlgotithm {

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
        Integer[] arr = {4, 5, 2, 6, 3, 1, 8, 7};
        AlgorithmHelper.sort(ShellSortRe.class, "ShellSortRe", arr);
    }
}
