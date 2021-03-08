package csdn.stack;

/**
 * @description:
 * @create: 2021/3/8 08:27:51
 **/
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
