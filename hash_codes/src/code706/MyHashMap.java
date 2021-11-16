package code706;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MyHashMap
 * @Author lihuasong
 * @Description
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *  
 *
 * 提示：
 *
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 *
 * @Date 2021-11-16 20:12
 * @Version V1.0
 **/

public class MyHashMap {
    private int[] arr;
    private Set<Integer> keys;
    public MyHashMap() {
        arr = new int[(int)Math.pow(10,6)];
        keys = new HashSet<>();
    }

    public void put(int key, int value) {
        arr[key] = value;
        keys.add(key);
    }

    public int get(int key) {
        if(keys.contains(key)){
            return arr[key];
        }else{
            return -1;
        }
    }

    public void remove(int key) {
        keys.remove(key);
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        System.out.println(map.get(2));
        map.put(2,1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
