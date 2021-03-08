package csdn.array;


import java.util.Arrays;

/**
 * @description:
 * @create: 2021/3/3 09:07:05
 **/
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中指定位置添加元素
     *
     * @param element
     * @param index
     */
    public void add(E element, int index) {
        //1.判断数组是否已满,由于数组需要动态扩容，此处代码不需要了
//        if (size == data.length) {
//            throw new RuntimeException("add element failed;array is full");
//        }

        //2.判断index是否合法
        if (index < 0 || index > size) {
            throw new RuntimeException("add element failed; index is illage");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        //3.开始插入元素
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;
        size++;
    }

    /**
     * 向数组末尾添加元素
     *
     * @param element
     */
    public void addLast(E element) {
        add(element, size);
    }

    /**
     * 向数组头部添加元素
     *
     * @param element
     */
    public void addFirst(E element) {
        add(element, 0);
    }

    /**
     * 获取元素
     *
     * @param index
     * @returnr
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index is illage");
        }

        return data[index];
    }

    /**
     * 修改指定位置的元素
     *
     * @param index
     * @param element
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index is illage");
        }
        data[index] = element;
    }

    /**
     * 判断数组中是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素位置
     *
     * @param element
     * @return
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定index位置上的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index is illage");
        }
        E result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        newData = null;
    }

    /**
     * 删除数组中的第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中具体的元素
     *
     * @param element
     */
    public void removeElement(E element) {
        int index = find(element);
        if (index == -1) {
            throw new RuntimeException("element is not exits in array");
        }
        remove(index);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return getFirst();
    }
}
