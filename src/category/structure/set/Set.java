package category.structure.set;

/**
 * @description:
 * @create: 2020/9/8 10:16:24
 **/
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

}
