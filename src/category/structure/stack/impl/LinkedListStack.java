package category.structure.stack.impl;

import category.structure.linked.MyLinkedListUp;
import category.structure.stack.MyStack;

/**
 * @description:
 * @create: 2020/8/11 09:47:14
 **/
public class LinkedListStack<E> implements MyStack<E> {

    private MyLinkedListUp<E> linkedList;

    public LinkedListStack() {
        this.linkedList = new MyLinkedListUp<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
       StringBuffer res = new StringBuffer();
       res.append("Stack top:");
       res.append(linkedList);
       return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0; i < 5;i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        linkedListStack.pop();
        System.out.println(linkedListStack);
    }
}
