package category.structure.stack;

import category.structure.queue.Myqueue;
import category.structure.queue.impl.ArrayQueue;
import category.structure.queue.impl.LoopQueue1;
import category.structure.stack.impl.ArrayStack;
import category.structure.stack.impl.LinkedListStack;

import java.util.Random;
import java.util.Stack;

/**
 * @author songshiyu
 * @date 2020/8/8 10:29
 **/
public class TestStack {
    public static void main(String[] args) {
        int capacity = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayStackCostTime = testStack(arrayStack, capacity);
        System.out.println("ArrayStack cost time is:" + arrayStackCostTime);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListStackCostTime = testStack(linkedListStack, capacity);
        System.out.println("linkedListStack cost time is:" + linkedListStackCostTime);
    }

    public static double testStack(MyStack stack, int capacity) {
        long startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Random random = new Random();
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < capacity; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
