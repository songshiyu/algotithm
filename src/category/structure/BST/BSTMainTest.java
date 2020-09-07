package category.structure.BST;

/**
 * @description:
 * @E-mail: ssy3@meitu.com
 * @create: 2020/9/3 10:13:46
 **/
public class BSTMainTest {

    public static void main(String[] args) {
        BST bst = new BST();
        Integer[] arr = {5, 3, 4, 5, 11, 65, 3, 2, 7, 23, 65, 342, 9};

        for (Integer e : arr) {
            bst.addNotR(e);
        }

        //boolean contains = bst.contains(50);
        //System.out.println(contains);

        //bst.preOrder();
        //System.out.println();
        //bst.preOrderNR();
        //bst.midOrder();
        //bst.lastOrder();
        //System.out.println(bst);

        //bst.levelOrder();
        //Integer min = (Integer) bst.maxMemNR();
        //System.out.println(min);

        Integer removeEle = (Integer) bst.removeMaxNR();
        System.out.println(removeEle);
    }
}
