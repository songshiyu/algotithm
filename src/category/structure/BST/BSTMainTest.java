package category.structure.BST;

/**
 * @description:
 * @E-mail: ssy3@meitu.com
 * @create: 2020/9/3 10:13:46
 **/
public class BSTMainTest {

    public static void main(String[] args) {
        BST bst = new BST();
        Integer[] arr = {3, 4, 5, 11, 65, 3, 7, 23, 65, 342, 9};

        for (Integer e : arr) {
            bst.add(e);
        }

        System.out.println(bst);
    }
}