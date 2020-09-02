package category.binarysearch;

/**
 * @description: 如果有序数组中存在指定元素，返回该元素的最小索引
 * 如果有序数组中不存在指定元素，则返回小于该元素的最大索引
 * 思路：
 * 只需要先求出小于该元素的最大索引即可
 * @create: 2020/9/1 09:22:24
 **/
public class Lower_floor {

    public static <E extends Comparable<E>> int search(E[] arr, E target) {

        int index = lower(arr, target);

        if (index + 1 <= arr.length - 1 && arr[index + 1].compareTo(target) == 0) {
            index += 1;
        }

        return index;
    }

    public static <E extends Comparable<E>> int lower(E[] arr, E target) {
        int l = 0, r = arr.length;

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
        Integer[] arr = {1, 2, 3, 3, 4, 5, 6, 7};
        Integer target = 3;

        int index = search(arr, target);
        System.out.println(index);
    }

}
