package review.sort.mergesort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description:
 * @create: 2020/9/16 16:24:13
 * int[] arr = {3,1,2,6,5,4,7}
 * 第一轮：
 * int l = 0, int r = 7, int mid = 3
 * 第二轮：
 * int l = 0, int r = 3, int mid = 1 || int l = 4, int r = 7, int mid = 5
 * 第三轮：
 * int l = 0, int r = 1, int mid = 0
 * int l = 2, int r = 3, int mid = 2
 * int l = 4, int r = 5, int mid = 4
 * int l = 6, int r = 7, int mid = 6
 * 第四轮：
 * int l = 0, int r = 0
 * int l = 1, int r = 1
 * int l = 2, int r = 2
 * int l = 3, int r = 3
 * int l = 4, int r = 4
 * int l = 5, int r = 5
 * int l = 6, int r = 6
 * int l = 7, int r = 7
 **/
public class MergeSort extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        //第二处优化，提前做数组的复制，防止每次递归都去申请数组空间
        E[] tmp = Arrays.copyOfRange(arr, 0, arr.length);
        sort(arr, 0, arr.length - 1, tmp);
    }

    private <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] tmp) {

        if (l >= r) {
            return;
        }

        int mid = (r - l) / 2 + l;
        sort(arr, l, mid, tmp);
        sort(arr, mid + 1, r, tmp);

        //第一处优化：若第一个数组的最后一个元素小于第二个数组的第一个元素，那么后续的merge过程则不需要进行，因为每个数组内部都是有序的
        //反之，则进行后续的merge过程
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, tmp);
        }
    }

    private <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] tmp) {

        System.arraycopy(arr, l, tmp, 0, (r - l) + 1);

        //int l = 0, int r = 1, int mid = 0
        //int i = 0,j = 1,mid = 0,r = 1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l].compareTo(tmp[j - l]) <= 0) {
                arr[k] = tmp[i - l];
                i++;
            } else {
                arr[k] = tmp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] array = ArrayGenerator.generatorRandArray(n, n);

        AlgorithmHelper.sort(MergeSort.class, "MergeSort", array);
    }
}
