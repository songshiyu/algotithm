package util;

import java.util.Random;

/**
 * @author songshiyu
 * @date 2020/8/2 9:55
 **/
public class ArrayGenerator {

    /**
     * 生成一个固定大小的有序数组
     * */
    public static Integer[] generatorArray(int arraySize){
        Integer[] arr = new Integer[arraySize];
        for (int i = 0;i < arraySize;i++){
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个固定大小的，无序数组
     * */
    public static Integer[] generatorRandArray(int arraySize,int bound){
        Integer[] array = new Integer[arraySize];

        Random random = new Random();
        for (int i = 0; i< array.length;i++){
            int nextInt = random.nextInt(bound);
            array[i] = nextInt;
        }
        return array;
    }

}
