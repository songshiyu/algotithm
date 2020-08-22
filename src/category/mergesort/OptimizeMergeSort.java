package category.mergesort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 对归并排序算法内存上的优化，自顶向下的归并排序
 * @create: 2020/8/19 09:30:25
 **/
public class OptimizeMergeSort extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    private <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        /**
         * 此处对归并排序过程中内存的使用上进行了优化，不需要每次调用merge时去为temp开辟空间
         * */
        System.arraycopy(arr, l, temp, 0, r - l + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int capacity = 100000;
        Integer[] array = ArrayGenerator.generatorRandArray(capacity, capacity);

        AlgorithmHelper.sort(OptimizeMergeSort.class, "OptimizeMergeSort", array);
    }
}
