package category.quicksort;

import java.util.Random;

/**
 * @description: 查找无序数组中第k小的元素
 * @create: 2020/8/27 09:12:15
 **/
public class SelectMinK {

    public int findKthMin(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Illegal k,please check!");
        }

        Random random = new Random();
        selectKMin(arr, 0, arr.length - 1, random);
        return arr[k - 1];
    }

    private void selectKMin(int[] arr, int l, int r, Random random) {

        if (l >= r) {
            return;
        }

        int mid = partition(arr, l, r, random);
        selectKMin(arr, l, mid - 1, random);
        selectKMin(arr, mid + 1, r, random);
    }

    private int partition(int[] arr, int l, int r, Random random) {

        int index = random.nextInt(r - l + 1) + l;

        swap(arr, l, index);

        int i = l + 1, j = r;

        while (true) {

            while (i <= j && arr[i] < arr[l]) {
                i++;
            }

            while (j >= i && arr[j] > arr[l]) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 1, 7, 9, 8};
        SelectMinK selectMinK = new SelectMinK();
        int mink = selectMinK.findKthMin(arr, arr.length + 1);
        System.out.println(mink);
    }

}

