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


    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        return data[index];
    }
}
