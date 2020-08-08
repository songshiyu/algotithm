package category.structure.stack;

/**
 * @author songshiyu
 * @date 2020/8/6 15:22
 *
 * 1.栈也是一种数据结构
 * 2.相对于数组，栈对应的操作是数组的子集
 * 3.只能从一边添加元素，也只能从一边取出元素
 * 4.栈是一种后进先出的数据结构(LIFO  last in first out)
 **/
public interface MyStack<E> {

    /**
     * 得到栈的大小
     * */
    int getSize();

    /**
     * 判断栈是否为空
     * */
    boolean isEmpty();

    /**
     * 向栈顶插入元素
     * */
    void push(E e);

    /**
     * 从栈顶取出元素
     * */
    E pop();

    /**
     * 查看栈顶元素
     * */
    E peek();

}
