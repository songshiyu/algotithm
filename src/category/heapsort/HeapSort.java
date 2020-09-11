package category.heapsort;

import category.mergesort.OptimizeMergeSort;
import category.quicksort.DoubleWayQuickSort;
import category.quicksort.QuickSortThreeWays;
import category.structure.heap.MaxHeap;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 堆排序初版
 * @create: 2020/9/11 08:51:05
 **/
public class HeapSort<E extends Comparable<E>> extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        MaxHeap<E> maxHeap = new MaxHeap<>(arr.length);
        for (E e : arr) {
            maxHeap.add(e);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

    }

    public static void main(String[] args) {
        int capacaty = 1000000;
        Integer[] data1 = ArrayGenerator.generatorRandArray(capacaty, capacaty);
        Integer[] data2 = Arrays.copyOf(data1, data1.length);
        Integer[] data3 = Arrays.copyOf(data1, data1.length);
        Integer[] data4 = Arrays.copyOf(data1, data1.length);


        AlgorithmHelper.sort(HeapSort.class,"HeapSort",data1);
        AlgorithmHelper.sort(OptimizeMergeSort.class,"OptimizeMergeSort",data2);
        AlgorithmHelper.sort(DoubleWayQuickSort.class,"DoubleWayQuickSort",data3);
        AlgorithmHelper.sort(QuickSortThreeWays.class,"QuickSortThreeWays",data4);

    }
}
