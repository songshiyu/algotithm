package category.insertsort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;

import java.util.Arrays;


/**
 * @author songshiyu
 * @date 2020/8/2 10:36
 **/
public class Insert extends BaseAlgotithm {

   /* //每个元素多次交换位置
   @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        //每个元素多次交换位置
         for (int i = 0; i< arr.length;i++){
            for (int j = i; j - 1 >= 0;j--){
                if (arr[j].compareTo(arr[j-1]) < 0){
                    AlgorithmHelper.swap(arr,j-1,j);
                }else {
                    break;
                }
            }
        }
    }*/

    /**
     * 优化 每个元素只交换一次位置,通过平移的方式
     */
   /* @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E tmp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }*/

    /**
     * 从后向前实现插入排序法
     * */
    @Override
    public <E extends Comparable<E>> void sort(E[] arr){
        for (int i = arr.length -1; i >= 0; i--){
            E tmp = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && tmp.compareTo(arr[j + 1]) > 0;j++){
                arr[j] = arr[j + 1];
            }
            arr[j] = tmp;
        }
    }


    public static void main(String[] args) {

        Integer[] arr = {4,2,1,5,6,3};
        Insert insert = new Insert();
        insert.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);

       /* Integer[] dataSizes = {10000, 100000};

        for (Integer dataSize : dataSizes) {
            Integer[] array = ArrayGenerator.generatorRandArray(dataSize, dataSize);
            AlgorithmHelper.sort(Insert.class, "InsertSort", array);
        }*/
    }
}
