package category.bubblesort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

/**
 * @description: 从后向前的实现冒泡排序
 * @create: 2020/9/17 09:30:08
 **/
public class AnotherBulleSort extends BaseAlgotithm {

    /**
     * int[] arr = {4,2,1,6,5,3}
     */

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        /**
         * 最外层循环是用来控制有序数组的个数
         * */
        for (int i = 0; i < arr.length - 1; ) {

            int lastSwapIndex = arr.length - 1;

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    AlgorithmHelper.swap(arr, j, j - 1);
                    lastSwapIndex = j - 1;
                }
            }
            i = lastSwapIndex + 1;
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        AlgorithmHelper.sort(AnotherBulleSort.class, "AnotherBulleSort", array);
    }
}
