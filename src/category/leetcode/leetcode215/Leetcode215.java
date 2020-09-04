package category.leetcode.leetcode215;


import java.util.Random;

/**
 * @description: 找出数组中第k个最大元素
 * 思路：可以使用快速排序来做
 * @create: 2020/8/27 09:15:27
 **/
public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {

        if (k > nums.length) {
            return -1;
        }

        Random random = new Random();
        selectMaxK(nums, 0, nums.length - 1, random);

        return nums[nums.length - k];
    }

    private void selectMaxK(int[] arr, int l, int r, Random random) {

        if (l >= r) {
            return;
        }

        int mid = partition(arr, l, r, random);
        selectMaxK(arr, mid + 1, r, random);
        selectMaxK(arr, l, mid - 1, random);
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
}
