package category.binarysearch;

/**
 * @description: 第一版二分查找法 leetcode704题  使用递归的方式实现二分查找
 * @create: 2020/8/28 08:36:48
 **/
public class BinarySearchR {

    private BinarySearchR() {

    }

    public <E extends Comparable<E>> int searchR(E[] arr, E target) {
        return searchR(arr, 0, arr.length - 1, target);
    }

    private <E extends Comparable<E>> int searchR(E[] arr, int l, int r, E target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (target.compareTo(arr[mid]) == 0) {
            return mid;
        } else if (target.compareTo(arr[mid]) < 0) {
            return searchR(arr, l, mid - 1, target);
        }
        return searchR(arr, mid + 1, r, target);
    }
}

