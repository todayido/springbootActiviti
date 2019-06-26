package CollectionTest;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        Map map2 = new HashMap<>();
//        System.out.println(map.put("one", "1"));
//        System.out.println(map.put("two", "1"));
//        System.out.println(map.put(null, null));
//        System.out.println(map.put("zero", "0"));
//        System.out.println(map.put("zero", "3"));
//        System.out.println(map.put("zero", "5"));
//        System.out.println(map);

//        Set<String> keySets = map.keySet();
//        System.out.println(keySets);

//        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
//        while (itr.hasNext()) {
//            Map.Entry<String, String> me = itr.next();
//            System.out.print(me.getKey()+" : "+me.getValue()+"、");
//        }
//
//        Set<Map.Entry<String, String>> me = map.entrySet();
//        for (Map.Entry<String, String> stringStringEntry : me) {
//            System.out.print(stringStringEntry.getKey() + ":" + stringStringEntry.getValue() + "  ");
//        }

        map.put(new Person("张三", 23), "林内");
        map.put(new Person("张三", 25), "林xiao");
        map2.put("1", "1");
        map2.put("2", "1");
        map2.put("2", "2");
        map2.put("2", "1");
        System.out.println(map.size());
        System.out.println(map2.size());
        System.out.println(map.get(new Person("张三", 25)));


    }
}
