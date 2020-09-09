package category.structure.map;

/**
 * @description:
 * @create: 2020/9/9 09:15:58
 **/
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    int getSize();

    boolean isEmpty();

    void set(K key, V value);

}
