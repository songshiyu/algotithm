package category.structure.queue.impl;

import category.structure.queue.Myqueue;


/**
 * @author songshiyu
 * @date 2020/8/8 10:41
 *
 * TODO => 不使用size记录队列大小，浪费一个队列空间
 **/
public class LoopQueue3<E> implements Myqueue<E>{

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue3(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.tail = 0;
    }

    public LoopQueue3() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not get from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not get from an empty queue");
        }
        return data[front];
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue: size:%s capacity:%s\n",size,getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++){
            res.append(data[(front + i) % data.length]);
            if (i != size -1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
