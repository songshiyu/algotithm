package category.bubblesort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 冒泡排序的进一步优化
 * @create: 2020/9/17 09:17:20
 **/
public class OptimizedBulleSort2 extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; ) {

            /**
             * 记录下最后一个发生交换的索引
             * */
            int lastSwapIndex = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    AlgorithmHelper.swap(arr, j, j + 1);
                    lastSwapIndex = j + 1;
                }
            }
            i = arr.length - lastSwapIndex;
        }
    }

    public static void main(String[] args) {
        int n = 20000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        Integer[] copy1 = Arrays.copyOf(array, array.length);
        Integer[] copy2 = Arrays.copyOf(array, array.length);

        AlgorithmHelper.sort(BubbleSort.class, "random：BubbleSort", copy1);
        AlgorithmHelper.sort(OptimizedBulleSort.class, "random：OptimizedBulleSort", array);
        AlgorithmHelper.sort(OptimizedBulleSort2.class, "random：OptimizedBulleSort2", copy2);

        Integer[] array1 = ArrayGenerator.generatorArray(n);
        Integer[] copy3 = Arrays.copyOf(array1, array1.length);
        Integer[] copy4 = Arrays.copyOf(array1, array1.length);

        AlgorithmHelper.sort(BubbleSort.class, "order：BubbleSort", copy3);
        AlgorithmHelper.sort(OptimizedBulleSort.class, "order：OptimizedBulleSort", array1);
        AlgorithmHelper.sort(OptimizedBulleSort2.class, "order：OptimizedBulleSort2", copy4);
    }
}
