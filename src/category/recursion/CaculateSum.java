package category.recursion;

/**
 * @description: 使用递归对数组求和
 * @create: 2020/8/13 08:51:56
 **/
public class CaculateSum {

    public static int sum(int[] arr) {
        int sum = sum(arr, 0);
        return sum;
    }

    private static int sum(int[] arr, int index) {

        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int res = sum(arr);
        System.out.println(res);
    }
}
