package category.structure.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 使用优先队列，完成TOPk，N个元素中选取出最大的k个元素 || 使用java标准库自带的优先队列
 * @create: 2020/9/16 08:28:05
 **/
public class SelectK {

    public static int[] getMaxNNums(int[] arr, int k) {

        //java中自带的优先队列，默认是按自然序排列，也就是由小到大
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 8, 1, 5, 2, 6, 9, 7};
        int k = 4;

        int[] nums = getMaxNNums(arr, k);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
