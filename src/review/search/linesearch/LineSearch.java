package review.search.linesearch;

/**
 * @description: 线性查找法
 * @create: 2020/9/15 16:49:27
 **/
public class LineSearch {

    private LineSearch() {

    }

    public static <E extends Comparable<E>> int search(E[] arr, E target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }
}
