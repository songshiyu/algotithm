package category.bubblseort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

/**
 * @description: 冒泡排序
 * @create: 2020/9/17 08:41:14
 **/
public class BubbleSort extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        /**
         * 最外层循环是用来控制有序数组的个数
         * */
        for (int i = 0; i < arr.length; i++) {

            /**
             * 第二轮循环是真正用来比较的
             * */
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    AlgorithmHelper.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        AlgorithmHelper.sort(BubbleSort.class,"BubbleSort",array);
    }
}
