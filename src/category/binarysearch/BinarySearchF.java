package category.binarysearch;

/**
 * @description: 二分查找第二版：使用循环实现二分查找
 * @create: 2020/8/28 08:50:54
 **/
public class BinarySearchF {

    private BinarySearchF() {

    }

    public <E extends Comparable<E>> int searchF(E[] arr, E target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
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
