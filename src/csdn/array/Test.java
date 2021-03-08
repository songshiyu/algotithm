package csdn.array;

import java.util.*;

/**
 * @description:
 * @create: 2021/3/5 15:10:03
 **/
public class Test {

    public static void main(String[] args) {

        System.out.println(-4 >> 2);

        HashMap<String,String> hashMap = new HashMap<>(16,0.75f);

        hashMap.put("songshiyu","1231");

        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };

        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        // 模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project3");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        //触发删除
        accessOrderedMap.put("Project4", "songshiyu");
        System.out.println("Oldest entry should be removed:");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

    }
}
