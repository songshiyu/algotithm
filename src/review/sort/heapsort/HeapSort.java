package review.sort.heapsort;

import review.sort.quickSort.QuickSort3;
import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 使用堆完成原地排序
 * @create: 2020/9/22 10:12:54
 **/
public class HeapSort extends BaseAlgotithm {


    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        if (arr.length <= 1) {
            return;
        }

        //从最后一个父节点开始进行下沉操作
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            //将最大堆的根节点与最小节点进行交换，这样最大的节点位于最大堆的最后一个节点，且从(i,arr.length -1]区间元素是由小到大的。
            AlgorithmHelper.swap(arr, 0, i);
            //然后从根节点开始进行下沉操作，直到第i个元素
            siftDown(arr, 0, i);
        }
    }

    /**
     * 下沉操作，维护二叉堆特定，父节点永远比子节点大
     * 父节点k对应的子节点 分别为2K + 1 和 2K + 2
     *
     * @param arr 待排序的数组
     * @param k   父节点
     * @param n   二叉堆中未排序的元素个数
     */
    private <E extends Comparable<E>> void siftDown(E[] arr, int k, int n) {

        //循环条件，父节点对应的第一个
        while (2 * k + 1 < n) {

            //找出父节点对应的两个子节点中较大值
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0) {
                j++;
            }

            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }

            AlgorithmHelper.swap(arr, j, k);
            k = j;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);
        Integer[] copy = Arrays.copyOf(array, array.length);

        AlgorithmHelper.sort(HeapSort.class, HeapSort.class.getName(), array);
        AlgorithmHelper.sort(QuickSort3.class, QuickSort3.class.getName(), copy);
    }
}
