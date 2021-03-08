package csdn.stack;

/**
 * @description: 栈
 * @create: 2021/3/8 08:15:38
 **/
public interface Stack<E> {

    void push(E element);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
