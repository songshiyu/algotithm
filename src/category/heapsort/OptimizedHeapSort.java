package category.heapsort;

import category.mergesort.OptimizeMergeSort;
import category.quicksort.DoubleWayQuickSort;
import category.quicksort.QuickSortThreeWays;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 原地完成堆排序
 * @create: 2020/9/15 08:40:07
 **/
public class OptimizedHeapSort<E extends Comparable<E>> extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        if (arr.length <= 1) return;

        //从最后一个节点的父节点开始，依次进行下沉操作
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            AlgorithmHelper.swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    public <E extends Comparable<E>> void siftDown(E[] arr, int k, int n) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1; // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0) {
                // data[j] 是 leftChild 和 rightChild 中的最大值
                j++;
            }

            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }

            AlgorithmHelper.swap(arr, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int capacaty = 1000000;
        Integer[] data1 = ArrayGenerator.generatorRandArray(capacaty, capacaty);
        Integer[] data2 = Arrays.copyOf(data1, data1.length);

        AlgorithmHelper.sort(HeapSort.class, "HeapSort", data1);
        AlgorithmHelper.sort(OptimizedHeapSort.class, "OptimizedHeapSort", data2);

    }
}
