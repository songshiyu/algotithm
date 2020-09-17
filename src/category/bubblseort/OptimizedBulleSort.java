package category.bubblseort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

/**
 * @description: 冒泡排序的优化
 * @create: 2020/9/17 08:50:27
 **/
public class OptimizedBulleSort extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        /**
         * 最外层循环是用来控制有序数组的个数
         * */
        for (int i = 0; i < arr.length; i++) {

            boolean isSwap = false;

            /**
             * 第二轮循环是真正用来比较的
             * */
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    AlgorithmHelper.swap(arr, j, j + 1);
                    isSwap = true;
                }
            }

            /**
             * 如果一直没有发生交换，那么说明数组是有序的，可以直接break
             * */
            if (!isSwap) break;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        AlgorithmHelper.sort(OptimizedBulleSort.class, "random：OptimizedBulleSort", array);

        Integer[] array1 = ArrayGenerator.generatorArray(n);
        AlgorithmHelper.sort(OptimizedBulleSort.class, "order：OptimizedBulleSort", array1);
    }
}
