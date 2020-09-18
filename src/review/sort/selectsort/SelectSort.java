package review.sort.selectsort;

import category.seletesort.SelecterSort;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

/**
 * @description:
 * @create: 2020/9/18 15:44:06
 **/
public class SelectSort extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    AlgorithmHelper.swap(arr, minIndex, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] dataSizes = {10000,100000};

        for (Integer dataSize:dataSizes){
            Integer[] array = ArrayGenerator.generatorRandArray(dataSize, dataSize);
            AlgorithmHelper.sort(SelectSort.class,"SelectSort",array);
        }
    }
}
