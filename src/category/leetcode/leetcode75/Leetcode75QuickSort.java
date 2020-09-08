package category.leetcode.leetcode75;

import java.util.Random;

/**
 * @description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * @create: 2020/8/27 08:56:28
 **/
public class Leetcode75QuickSort {

    /**
     * 假设红色为1 白色为2 蓝色为3
     */
    public void sortColors(int[] nums) {
        Random random = new Random();
        sortBall(nums, 0, nums.length - 1, random);
    }

    private void sortBall(int[] arr, int l, int r, Random random) {

        if (l >= r) {
            return;
        }

        int partition = partition(arr, l, r, random);
        sortBall(arr, l, partition - 1, random);
        sortBall(arr, partition + 1, r, random);
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
        int[] arr = {1, 2, 3, 2, 1, 3, 3, 2, 1, 2, 1, 3, 2, 1, 3};
        Leetcode75QuickSort leetcode75QuickSort = new Leetcode75QuickSort();
        leetcode75QuickSort.sortColors(arr);
        System.out.println(arr);
    }

}
