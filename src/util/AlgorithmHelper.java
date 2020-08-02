package util;


/**
 * @author songshiyu
 * @date 2020/8/2 10:01
 **/
public class AlgorithmHelper {

    /**
     * 通用测试
     * */
    public static <E extends Comparable<E>> void sort(Class clazz,String className,E[] arr){

        try {
            BaseAlgotithm algotithm = (BaseAlgotithm) clazz.getConstructor().newInstance();
            long startTime = System.nanoTime();
            algotithm.sort(arr);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.00;

            if (!checkSort(arr)) {
                throw new RuntimeException("Sort failed");
            }
            System.out.println(String.format("%s: n = %d, 执行时间 = %f s", className,arr.length,time));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("new Instance fail");
        }
    }

    /**
     * 检查排序结果是否正确
     * */
    public static <E extends Comparable> boolean checkSort(E[] arr){
        for (int i = 1; i < arr.length;i++){
            if (arr[i-1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 数组元素交换位置
     * */
    public static <E> void swap(E[] arr,int i,int j){
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
