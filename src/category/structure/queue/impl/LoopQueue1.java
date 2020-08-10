package category.structure.queue.impl;

import category.structure.queue.Myqueue;

/**
 * @description:
 * @create: 2020/8/7 09:02:44
 *
 * 循环队列
 *     1.分别使用front、tail记录队列的头和尾
 *     2.因为是循环队列，因此可以使用(tail + 1) % data.length == front判断队列是否已满
 *
 *  使用size记录队列大小，且会浪费队列的一个空间。
 **/
public class LoopQueue1<E> implements Myqueue<E> {

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue1(int capacity){
        data = (E[])new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue1(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //1.首先判断当前队列是否已满
        if ((tail + 1) % data.length == front){
            //若队列已满，则进行扩容操作
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("can not dequeue from a empty queue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == data.length / 4 && data.length / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {

        if (isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size;i++){
            newData[i] = data[(i + front) / data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }


    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue: size:%s capacity:%s \n",size,getCapacity()));
        res.append("front [");

        for (int i = front; i != tail;i = (i + 1) % data.length){
            res.append(i);

            if ((i + 1) % data.length != tail){
                res.append(",");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue1<Integer> loopQueue1 = new LoopQueue1<>(5);

        for (int i = 0; i < 6; i++){
            loopQueue1.enqueue(i);
            System.out.println(loopQueue1);
        }

        loopQueue1.dequeue();
        System.out.println(loopQueue1);
    }
}
