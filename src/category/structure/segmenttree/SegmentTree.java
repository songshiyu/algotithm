package category.structure.segmenttree;

import org.omg.CORBA.Object;

/**
 * @description: 线段树
 * @create: 2020/9/22 09:54:19
 **/
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    private SegmentTree() {
    }

    public SegmentTree(E[] array) {

        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }

        tree = (E[]) new Object[array.length * 4];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index) {
        return 2 * index + 2;
    }

}
