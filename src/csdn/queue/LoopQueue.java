package csdn.queue;

/**
 * @description: 循环队列
 * @create: 2021/3/9 08:28:30
 **/
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail, size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {

        if (size == data.length - 1) {
            resize((data.length - 1) * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length - 1;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            newData[i + front] = data[i + front];
        }
        data = newData;
        newData = null;
    }

    @Override
    public E dequeue() {

        if (front == tail) {
            throw new RuntimeException("queue is empty!");
        }

        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size < data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return result;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoopQueue: front [ ");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append("index：" + i + "- value：" + data[i]);
            if (i != tail % data.length - 1) {
                builder.append(",");
            }
        }
        builder.append(" ] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        System.out.println(loopQueue.getSize());

        System.out.println("--------------华丽的分割线-----------");

        loopQueue.dequeue();
        System.out.println(loopQueue);
        System.out.println(loopQueue.getSize());

        loopQueue.enqueue(11);
        System.out.println(loopQueue);
        System.out.println(loopQueue.getSize());
    }
}
