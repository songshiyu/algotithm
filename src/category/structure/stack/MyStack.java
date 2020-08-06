package category.structure.stack;

/**
 * @author songshiyu
 * @date 2020/8/6 15:22
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
