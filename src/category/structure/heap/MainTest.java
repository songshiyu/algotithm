package category.structure.heap;


import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @create: 2020/9/14 09:37:06
 **/
public class MainTest {

    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>(testData.length);
            for (int e : testData) {
                maxHeap.add(e);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int j = 1; j < testData.length; j++) {
            if (arr[j] > arr[j - 1]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 2000000;

        Integer[] testData1 = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData1[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double isNotHeapify = testHeap(testData1, false);
        System.out.println("isNotHeapify cost : " + isNotHeapify);

        double isHeapify = testHeap(testData1, true);
        System.out.println("Heapify cost : " + isHeapify);
    }
}
