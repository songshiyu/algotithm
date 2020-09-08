package category.structure.set.impl;

import category.structure.linked.LinkedList;
import category.structure.linked.MyLinkedListUp;
import category.structure.set.Set;

/**
 * @description: 基于链表实现Set集合
 * @create: 2020/9/8 10:38:13
 **/
public class LinkedListSet<E> implements Set<E> {

    private MyLinkedListUp<E> linkedList;

    public LinkedListSet() {
        linkedList = new MyLinkedListUp<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
