package category.mergesort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 简陋版的归并排序
 * @create: 2020/8/18 08:22:55
 *
 *   int[] arr = {3,1,2,6,5,4,7}
 *   第一轮：
 *   int l = 0, int r = 7, int mid = 3
 *   第二轮：
 *   int l = 0, int r = 3, int mid = 1 || int l = 4, int r = 7, int mid = 5
 *   第三轮：
 *   int l = 0, int r = 1, int mid = 0
 *   int l = 2, int r = 3, int mid = 2
 *   int l = 4, int r = 5, int mid = 4
 *   int l = 6, int r = 7, int mid = 6
 *   第四轮：
 *   int l = 0, int r = 0
 *   int l = 1, int r = 1
 *   int l = 2, int r = 2
 *   int l = 3, int r = 3
 *   int l = 4, int r = 4
 *   int l = 5, int r = 5
 *   int l = 6, int r = 6
 *   int l = 7, int r = 7
 **/
public class MergeSort extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        /**
         * 归并排序的第一种优化
         * 因为两个数组是有序的，因此当前一个数组的最后一个元素小于后一个数组的第一个元素时
         * 两个数组合并后，本身就是有序的，因为不需要进行merge的过程
         * */
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    //合并两个有序区间arr[l,mid],arr[mid + 1,r]
    private <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        //int l = 0, int r = 1, int mid = 0
        //int i = 0,j = 1,mid = 0,r = 1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int capacity = 10;
        Integer[] array = ArrayGenerator.generatorRandArray(capacity, capacity);

        AlgorithmHelper.sort(MergeSort.class, "MergeSort", array);
    }
}
