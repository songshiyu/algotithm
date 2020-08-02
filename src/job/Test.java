package job;

import category.seleter.Selecter;
import util.AlgorithmHelper;
import util.ArrayGenerator;

/**
 * @author songshiyu
 * @date 2020/8/2 10:07
 **/
public class Test {

    public static void main(String[] args) {
        Integer[] dataSizes = {10000,100000};

        for (Integer dataSize:dataSizes){
            Integer[] array = ArrayGenerator.generatorRandArray(dataSize, dataSize);
            AlgorithmHelper.sort(Selecter.class,"Selecter",array);
        }

    }
}
