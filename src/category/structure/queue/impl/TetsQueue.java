package category.structure.queue.impl;

import category.structure.queue.Myqueue;

import java.util.Random;

/**
 * @author songshiyu
 * @date 2020/8/8 10:29
 **/
public class TetsQueue {
    public static void main(String[] args) {
        int  capacity = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueCostTime = testQueue(arrayQueue, capacity);
        System.out.println("ArrayQueue cost time is:" + arrayQueueCostTime);

        LoopQueue1<Integer> loopQueue1 = new LoopQueue1<>();
        double loopQueueCostTime = testQueue(loopQueue1, capacity);
        System.out.println("LoopQueue1 cost time is:" + loopQueueCostTime);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double LinkedListQueueCostTime = testQueue(linkedListQueue, capacity);
        System.out.println("LinkedListQueue cost time is:" + LinkedListQueueCostTime);
    }

    public static double testQueue(Myqueue myqueue, int capacity) {
        long startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Random random = new Random();
            myqueue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < capacity; i++) {
            myqueue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
