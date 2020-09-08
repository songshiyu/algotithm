package category.structure.set.impl;

import category.structure.BST.BST;
import category.structure.set.Set;

/**
 * @description: 基于二叉搜索树实现Set集合
 * @create: 2020/9/8 10:18:08
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.removeEle(e);
    }

    @Override
    public int getSize() {
        return bst.Size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
