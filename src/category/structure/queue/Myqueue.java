package category.structure.queue;

/**
 * @description:
 * @create: 2020/8/7 08:32:53
 * <p>
 * 1.队列是一种线性结构
 * 2.相对数组，队列对应的操作是数组的子集
 * 3.队列只能从一端(队尾)添加元素，只能从另一断(队首取出元素)
 * 4.是一种先进先出的数据结构(FIFO first in first out)
 **/
public interface Myqueue<E> {

    /**
     * 得到队列大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     * */
    boolean isEmpty();

    /**
     * 向队列添加元素
     * */
    void enqueue(E e);

    /**
     * 从队列取出元素
     * */
    E dequeue();

    /**
     * 获取队首元素
     * */
    E getFront();
}
