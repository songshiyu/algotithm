package csdn.array;

/**
 * @description:
 * @create: 2021/3/5 10:34:47
 **/
public class SparseArray {

    public static void main(String[] args) {
        //定义一个普通二维数组
        int[][] data = new int[9][9];
        data[0][3] = 1;
        data[2][5] = 3;
        data[5][0] = 23;

        //二维数组中共有多个非0值
        int sum = 0;

        System.out.println("------打印普通二维数组-------");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                System.out.print("  ");
                if (data[i][j] != 0) {
                    sum++;
                }
            }
            System.out.println();
        }

        //构造稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = data.length;
        sparseArray[0][1] = data[0].length;
        sparseArray[0][2] = sum;

        //记录第几个非0值
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = data[i][j];
                }
            }
        }

        System.out.println("-------输出稀疏数组---------");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        //还原稀疏数组
        int[][] recoverSparse = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            recoverSparse[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("-----输出还原后的稀疏数组-------");
        for (int i = 0; i < recoverSparse.length; i++) {
            for (int j = 0; j < recoverSparse[i].length; j++) {
                System.out.print(recoverSparse[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
