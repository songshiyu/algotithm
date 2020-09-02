package category.binarysearch;

/**
 * @description: 如果有序数组中存在指定元素，返回该元素的最大索引;如果有序数组中不存在指定元素，则返回小于该元素的最大索引
 * @create: 2020/9/1 09:24:53
 **/
public class Upper_floor {

    public static <E extends Comparable<E>> int search(E[] arr, E target) {

        int index = upper(arr, target);

        return index;
    }

    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        int l = 0, r = arr.length - 1;

        while (l < r) {

            int mid = l + (r - l + 1) / 2;

            if (arr[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 5, 6, 7};
        Integer target = 3;

        int index = search(arr, target);
        System.out.println(index);
    }

}
