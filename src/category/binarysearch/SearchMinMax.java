package category.binarysearch;

/**
 * @description: 在一个有序数组中，求比指定元素大的最小元素
 * @create: 2020/8/31 09:25:23
 **/
public class SearchMinMax {

    public static <E extends Comparable<E>> int search(E[] arr, E target) {

        int l = 0, r = arr.length;
        while (l < r) {

            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};

        int index = search(arr, 3);
        System.out.println(index);
    }

}
