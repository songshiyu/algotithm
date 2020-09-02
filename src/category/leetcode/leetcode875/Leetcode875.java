package category.leetcode.leetcode875;

import java.util.Arrays;

/**
 * @description: 使用二分搜索解决leetcode中第875题
 * @create: 2020/9/2 08:44:58
 **/
public class Leetcode875 {

    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (eatingTime(piles, mid) <= H) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int eatingTime(int[] piles, int k) {
        int sum = 0;

        for (int pile : piles) {
            sum += pile / k + (pile % k != 0 ? 1 : 0);
        }

        return sum;
    }

}
