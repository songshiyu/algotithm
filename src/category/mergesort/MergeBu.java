package category.mergesort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;

/**
 * @description: 自底向上的实现归并排序
 * @create: 2020/8/20 09:00:36
 **/
public class MergeBu extends BaseAlgotithm {

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        int length = arr.length;

        E[] temp = Arrays.copyOf(arr, length);

        //遍历合并的区间长度
        for (int sz = 1; sz < length; sz += sz) {

            //遍历合并的两个区间的起始位置 i
            //合并 [i,i + sz - 1] 和 [i + sz,Math.min(i + sz + sz - 1,n -1)]
            for (int i = 0; i + sz < length; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, length - 1), temp);
                }
            }
        }
    }

    private <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        System.arraycopy(arr, l, temp, 0, r - l + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int capacity = 100000;
        Integer[] array = ArrayGenerator.generatorRandArray(capacity, capacity);

        AlgorithmHelper.sort(MergeBu.class, "MergeBu", array);
    }
}
