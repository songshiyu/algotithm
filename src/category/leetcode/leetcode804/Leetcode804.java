package category.leetcode.leetcode804;

import java.util.TreeSet;

/**
 * @description: 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合
 * @create: 2020/9/9 09:18:13
 **/
public class Leetcode804 {


    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> treeSet = new TreeSet<>();

        for (String word : words) {

            StringBuffer res = new StringBuffer();

            for (int i = 0; i < word.length(); i++) {

                res.append(codes[word.charAt(i) - 'a']);
            }

            treeSet.add(res.toString());
        }

        return treeSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Leetcode804 leetcode804 = new Leetcode804();
        int res = leetcode804.uniqueMorseRepresentations(words);
        System.out.println(res);
    }
}
