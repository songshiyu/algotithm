package review.search.binarysearch;

/**
 * @description: 使用循环的方式实现二分查找法
 * @create: 2020/9/15 16:33:28
 **/
public class BinarySearchF {

    private BinarySearchF() {
    }

    public static <E extends Comparable<E>> int searchF(E[] arr, E target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
