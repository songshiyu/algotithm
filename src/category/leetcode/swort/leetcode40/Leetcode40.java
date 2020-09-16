package category.leetcode.swort.leetcode40;

import java.util.Comparator;

/**
 * @description: 最小的k个数 使用优先队列来解决
 * @create: 2020/8/27 09:17:57
 **/
public class Leetcode40 {

    public class MyArray<E> {

        private E[] data;
        private int size;

        /*
         * 构造函数，传入数组容量capacity构造MyArray
         * */
        public MyArray(int capacity) {
            data = (E[]) new Object[capacity];
            this.size = 0;
        }

        //无参构造函数，默认数组大小为10
        public MyArray() {
            this(10);
        }

        /**
         * 传入一个数组的构造函数
         */
        public MyArray(E[] arr) {
            data = (E[]) new Object[arr.length];

            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        //获取元素个数
        public int getSize() {
            return size;
        }

        //获取数组容量
        public int getCapacity() {
            return data.length;
        }

        //判断数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //向数组末尾添加元素
        public void addLast(E e) {
            add(size, e);
        }

        //向数组头部添加元素
        public void addHead(E e) {
            add(0, e);
        }

        //向数组的指定位置添加元素
        public void add(int index, E e) {

            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add failed. required correct index.");
            }

            if (size == data.length) {
                resize(data.length * 2);
            }

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
        }

        public E get(int index) {
            if (index < 0 || index > data.length - 1) {
                throw new IllegalArgumentException("Add failed. required correct index.");
            }
            return data[index];
        }

        public void set(int index, E e) {
            add(index, e);
        }

        @Override
        public String toString() {
            StringBuffer res = new StringBuffer();
            res.append(String.format("Array: size:%s, capacity:%s\n", size, data.length));
            res.append("[");
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size - 1) {
                    res.append(",");
                }
            }
            res.append("]");
            return res.toString();
        }

        /**
         * 判断数组中是否包含某元素
         */
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 查找数组中某元素的位置
         */
        public int findIndex(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 删除数组中的某个位置的元素，并返回元素
         */
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("remove failed. index is illegal");
            }

            E ret = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            data[size - 1] = null;     //删除无用的引用
            size--;

            if (size == data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            return ret;
        }

        /**
         * 删除数组的第一个元素
         */
        public E removeFist() {
            return remove(0);
        }

        /**
         * 删除数组的最后一个元素
         */
        public E removeLast() {
            return remove(size - 1);
        }

        /**
         * 删除数组中的指定元素
         */
        public void removeEle(E element) {
            int index = findIndex(element);
            if (index != -1) {
                remove(index);
            }
        }

        /**
         * 当数组容量不够时，自动扩容为之前容量的2倍
         */
        public void resize(int newCapacity) {
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        public E getFirst() {
            return get(0);
        }

        public E getLast() {
            return get(size - 1);
        }

        public void swap(int i, int j) {
            E tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }

    public class MaxHeap<E extends Comparable<E>> {

        private MyArray<E> data;

        public MaxHeap(int capacity) {
            data = new MyArray<>(capacity);
        }

        public MaxHeap() {
            data = new MyArray<>();
        }

        /**
         * Heapify 把一个数组以二叉堆的形式存放,直接写成构造函数的形式
         */
        public MaxHeap(E[] arr) {
            data = new MyArray<>(arr);

            if (arr.length != 1) {
                for (int i = parent(arr.length - 1); i >= 0; i--) {
                    siftDown(i);
                }
            }
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

        /**
         * replace 取出堆中的最大元素，并替换为另一个元素
         */
        public E replcae(E e) {
            E ret = findMax();

            data.set(0, e);
            siftDown(0);
            return ret;
        }
    }

    public interface Myqueue<E> {

        /**
         * 得到队列大小
         */
        int getSize();

        /**
         * 判断队列是否为空
         */
        boolean isEmpty();

        /**
         * 向队列添加元素
         */
        void enqueue(E e);

        /**
         * 从队列取出元素
         */
        E dequeue();

        /**
         * 获取队首元素
         */
        E getFront();
    }

    public class PriorityQueue<E extends Comparable<E>> implements Myqueue<E> {

        private MaxHeap<E> maxHeap;

        public PriorityQueue() {
            maxHeap = new MaxHeap<>();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }
    }

    /**
     * 使用自己编写的优先队列实现
     * */
    /*public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //首先将前k个数进入优先队列
        for (int i = 0; i < k; i++) {
            pq.enqueue(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.getFront()) {
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue();
        }

        return res;
    }*/

    /**
     * 使用java标准库自带的优先队列实现
     */
    public int[] getLeastNumbers(int[] arr, int k) {

        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }

        return res;
    }

}
