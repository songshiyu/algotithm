package category.structure.queue.impl;

import category.structure.array.MyArray;
import category.structure.queue.Myqueue;

/**
 * @description:
 * @create: 2020/8/7 08:41:14
 **/
public class ArrayQueue<E> implements Myqueue<E> {

    private MyArray<E> myArray;

    public ArrayQueue(int capacity){
        myArray = new MyArray<>(capacity);
    }

    public ArrayQueue(){
        myArray = new MyArray<>();
    }

    @Override
    public int getSize() {
        return myArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    public int getCapacity(){
        return myArray.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        myArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return myArray.removeFist();
    }

    @Override
    public E getFront() {
        return myArray.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Queue front [");
        for (int i = 0; i < myArray.getSize();i++){
            res.append(i);
            if (i != myArray.getSize() - 1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5;i++){
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }
}
