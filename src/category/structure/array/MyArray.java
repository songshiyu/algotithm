package category.structure.array;

import java.util.Arrays;

/**
 * @description:
 * @E-mail: ssy3@meitu.com
 * @create: 2020/8/3 09:27:46
 **/
public class MyArray {

    private int[] data;
    private int size;

    //构造函数，传入数组容量capacity构造MyArray
    public MyArray(int capacity) {
        data = new int[capacity];
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
    public void add(int e) {
        add(size, e);
    }

    //向数组头部添加元素
    public void addHead(int e) {
        add(0, e);
    }

    //向数组的指定位置添加元素
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full");
        }

        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("Add failed. required correct index.");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("Add failed. required correct index.");
        }
        return data[index];
    }

    public void set(int index, int e) {
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

    public static void main(String[] args) {
        MyArray myArray = new MyArray(11);
        for (int i = 0; i < 10; i++) {
            myArray.add(i);
        }
        System.out.println(myArray);
        myArray.add(8, 13);
        System.out.println(myArray);
    }
}
