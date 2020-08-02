package category.insertsort;

import util.AlgorithmHelper;
import util.ArrayGenerator;
import util.BaseAlgotithm;


/**
 * @author songshiyu
 * @date 2020/8/2 10:36
 **/
public class Insert  extends BaseAlgotithm{

    @Override
    public <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i< arr.length;i++){
            for (int j = i; j - 1 >= 0;j--){
                if (arr[j].compareTo(arr[j-1]) < 0){
                    AlgorithmHelper.swap(arr,j-1,j);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] dataSizes = {10000,100000};

        for (Integer dataSize:dataSizes){
            Integer[] array = ArrayGenerator.generatorRandArray(dataSize, dataSize);
            AlgorithmHelper.sort(Insert.class,"InsertSort",array);
        }
    }
}
