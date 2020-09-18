package review.search.binarysearch;

/**
 * @description: 复习- 使用递归的方式实现二分查找法
 * @create: 2020/9/15 16:17:14
 **/
public class BinarySearchR {

    private BinarySearchR() {

    }

    public static <E extends Comparable<E>> int searchR(E[] arr, E target) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }

        return searchR(arr, target, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> int searchR(E[] arr, E target, int l, int r) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (target.compareTo(arr[mid]) > 0) {
            return searchR(arr, target, mid + 1, r);
        } else {
            return searchR(arr, target, l, mid - 1);
        }
    }
}
