package category.structure.array;

import category.pojo.Student;

/**
 * @description:
 * @E-mail: ssy3@meitu.com
 * @create: 2020/8/3 09:27:46
 **/
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
    public void add(E e) {
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

        if (size == data.length / 4 && data.length / 2 != 0){
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
     * */
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size -1);
    }

    public static void main(String[] args) {

        MyArray<Student> array = new MyArray<>();
        array.add(new Student("songshiyu",20));
        array.add(new Student("liuweiming",18));
        array.add(new Student("songshiyu1",21));
        System.out.println(array);

        array.remove(2);
        System.out.println(array);
    }
}
