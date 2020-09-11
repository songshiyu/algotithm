package category.structure.heap;


import category.structure.array.MyArray;

import java.util.Random;

/**
 * @description: 基于数组实现最大堆
 * @create: 2020/9/10 09:35:18
 **/
public class MaxHeap<E extends Comparable<E>> {

    private MyArray<E> data;

    public MaxHeap(int capacity) {
        data = new MyArray<>(capacity);
    }

    public MaxHeap() {
        data = new MyArray<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    public int parent(int index) {

        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {

        //1.先将元素添加在数组的末尾
        data.addLast(e);

        //2.对该元素进行上浮，以保持二叉堆的特性
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {

        /**
         * 如果节点k的值大于节点k的父节点的值，那么将节点k与其父节点的值进行交换
         * */
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    //从堆中取出最大元素
    public E extractMax() {

        E ret = findMax();

        //将二叉堆的根节点与堆的最后一个节点进行交换
        data.swap(0, data.getSize() - 1);

        //此时移除交换后的最后一个节点,也就是取出了最大元素
        data.removeLast();

        //最后，对二叉堆进行维护，使其特性恢复
        siftDown(0);

        return ret;
    }

    /**
     * 将二叉堆中元素进行下沉，使其满足二叉堆特性
     */
    private void siftDown(int k) {

        //当目标节点的第一个子节点的索引超过数据的边界时，跳出循环
        while (leftChild(k) < data.getSize()) {

            int j = leftChild(k);

            //此步是为了选出目标节点的左孩子和右孩子中较大的值
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }

            //判断目标节点与两个子节点中较大值，谁更大，若子节点大，则将目标节点与子节点进行交换，循环继续。
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 查看堆中的最大元素
     * 因为二叉堆特性是父节点必须要大于子节点，因此，只需要将根节点取出即可。
     */
    public E findMax() {

        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }

        return data.get(0);
    }

    public static void main(String[] args) {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }

}
