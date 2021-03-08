package csdn.queue;

import csdn.array.Array;

/**
 * @description:
 * @create: 2021/3/8 09:16:25
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeLast();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue:front [");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}
