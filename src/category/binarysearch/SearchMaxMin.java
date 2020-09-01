package category.binarysearch;

/**
 * @description: 一个有序数组中比指定元素小的最大索引值
 * @create: 2020/9/1 09:19:14
 **/
public class SearchMaxMin {

    public static <E extends Comparable<E>> int search(E[] arr, E target) {

        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            if (arr[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,2,2,3,4,5,6};
        int index = search(arr, 3);
        System.out.println(index);
    }
}
