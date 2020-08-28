package category.binarysearch;

/**
 * @description:
 * @E-mail: ssy3@meitu.com
 * @create: 2020/8/28 09:25:22
 **/
public class Leetcode704 {

    public int search(int[] nums, int target) {
        return searchR(nums, 0, nums.length - 1, target);
    }

    private int searchR(int[] arr, int l, int r, int target) {

        int mid = l + (r - l) / 2;

        if (l > r) {
            return -1;
        }

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return searchR(arr, l, mid - 1, target);
        }
        return searchR(arr, mid + 1, r, target);
    }

    public int searchF(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
