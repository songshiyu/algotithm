package category.structure.queue.impl;

import category.structure.heap.MaxHeap;
import category.structure.queue.Myqueue;

/**
 * @description: 使用二叉堆实现优先队列
 * @create: 2020/9/15 08:53:06
 **/
public class PriorityQueue<E extends Comparable<E>> implements Myqueue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(E e) {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
