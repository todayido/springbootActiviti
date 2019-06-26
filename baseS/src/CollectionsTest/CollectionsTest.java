package CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "hello", "world");
        System.out.println(list); // [hello, world]

        Collections.reverse(list);
        System.out.println(list); // [world, hello]

        Collections.sort(list); // 先排序在用二分查找查找指定数据，返回索引从0开始
        System.out.println(Collections.binarySearch(list, "world"));
    }
}
