package category.seleter;

import util.BaseAlgotithm;

/**
 * @author songshiyu
 * @date 2020/8/2 9:46
 *
 * 选择排序
 **/
public class Selecter extends BaseAlgotithm{

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length;i++){

            int minIndex = i;
            for (int j = i; j < arr.length;j++){
                if (arr[minIndex].compareTo(arr[j]) > 0){
                    swap(arr,minIndex,j);
                }
            }
        }
    }

    public <E> void swap(E[] arr,int i,int j){
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
