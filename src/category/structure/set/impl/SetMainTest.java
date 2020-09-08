package category.structure.set.impl;

import util.FileOperation;

import java.util.ArrayList;

/**
 * @description:
 * @create: 2020/9/8 10:33:24
 **/
public class SetMainTest {

    public static void main(String[] args) {
        BSTSet<String> bstSet = new BSTSet<>();

        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile("/Users/songshiyu/data/algorithm/test1", words)) {
            System.out.println("BST =》Total words：" + words.size());

            for (String word : words) {
                bstSet.add(word);
            }
            System.out.println("BST =》Total different words: " + bstSet.getSize());
        }

        System.out.println("～～～～～～～～～华丽的分割线～～～～～～～～～～～");

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("/Users/songshiyu/data/algorithm/test1", words1)) {
            System.out.println("LinkedList =》Total words：" + words1.size());

            for (String word : words1) {
                linkedListSet.add(word);
            }
            System.out.println("LinkedList =》Total different words: " + linkedListSet.getSize());
        }
    }
}
