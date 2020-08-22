package category.leetcode.swort.leetcode51;

import java.util.Arrays;

/**
 * @description: 剑指offer 第51题，求数组中的逆序对个数
 * @create: 2020/8/20 08:58:56
 **/
public class ReversePair {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    public int sort(int[] nums, int l, int r, int[] temp) {

        if (l >= r) {
            return 0;
        }

        int res = 0;

        int mid = l + (r - l) / 2;
        res += sort(nums, l, mid, temp);
        res += sort(nums, mid + 1, r, temp);

        if (nums[mid] > nums[mid + 1]) {
            res += merge(nums, l, mid, r, temp);
        }
        return res;
    }

    public int merge(int[] nums, int l, int mid, int r, int[] temp) {
        int res = 0;
        System.arraycopy(nums, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                /**
                 * 尤其注意此处，只能先判断temp[i] <= temp[j]，然后在else中进行逆序数的累加
                 * 因为如果在temp[i] >= temp[j]中进行累加的话，会错误的将temp[i] = temp[j],也作为逆序数进行累加
                 *
                 * */
                nums[k] = temp[i];
                i++;
            } else {
                res += mid - i + 1;
                nums[k] = temp[j];
                j++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};

        ReversePair reversePair = new ReversePair();
        int i = reversePair.reversePairs(nums);
        System.out.println(i);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
