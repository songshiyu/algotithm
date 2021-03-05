package csdn.array;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @description:
 * @create: 2021/3/3 09:38:01
 **/
public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());

        array.addLast(11);
        System.out.println(array.toString());

        array.removeElement(0);
        System.out.println(array);

        /*System.out.println(array.get(5));

        System.out.println(array.contains(10));

        array.remove(6);
        System.out.println(array.toString());

        array.removeFirst();
        System.out.println(array.toString());

        array.removeLast();
        System.out.println(array.toString());

        array.removeElement(3);
        System.out.println(array.toString());

        array.set(1,15);
        System.out.println(array.toString());*/

        /*System.out.println("-------------------指定位置添加元素----------------------");
        array.add(10, 0);
        System.out.println(array);

        System.out.println("----------------向数组头部添加元素-------------------------");
        array.addFirst(11);
        System.out.println(array);

        System.out.println("----------------向数组尾部添加元素-------------------------");
        array.addLast(12);
        System.out.println(array);*/

    }
}
