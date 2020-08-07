package category.structure.stack.impl;

import category.structure.array.MyArray;
import category.structure.stack.MyStack;

/**
 * @author songshiyu
 * @date 2020/8/6 15:39
 **/
public class ArrayStack<E> implements MyStack<E>{

    private MyArray<E> myArray;

    public ArrayStack(int capacity){
        myArray = new MyArray<>(capacity);
    }

    public ArrayStack(){
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

    @Override
    public void push(E e) {
        myArray.addLast(e);
    }

    @Override
    public E pop() {
        return myArray.removeLast();
    }

    @Override
    public E peek() {
        return myArray.getLast();
    }

    public int getCapacity(){
        return myArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Stack [");
        for (int i = 0; i < myArray.getSize();i++){
            res.append(i);
            if (i != myArray.getSize() - 1){
                res.append(",");
            }
        }
        res.append("] Top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
