package category.leetcode.leetcode1011;

import java.util.Arrays;

/**
 * @description: 使用二分搜索解决leetcode第1011题
 * @create: 2020/9/2 08:45:29
 **/
public class Leetcode1011 {

    public int shipWithinDays(int[] weights, int D) {

        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (minShipWithinDays(weights, mid) <= D) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public int minShipWithinDays(int[] weights, int k) {
        int sum = 0, cur = 0;
        for (int weight : weights) {
            if (cur + weight <= k) {
                cur += weight;
            } else {
                cur = weight;
                sum++;
            }
        }
        sum++;
        return sum;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;

        Leetcode1011 leetcode1011 = new Leetcode1011();
        int days = leetcode1011.shipWithinDays(weights, D);
        System.out.println(days);
    }
}
