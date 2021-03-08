package csdn.queue;

/**
 * @description:
 * @create: 2021/3/8 09:15:22
 **/
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    boolean isEmpty();

    int getSize();
}
