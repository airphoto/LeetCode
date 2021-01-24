package code705;

/**
 * @ClassName MyHashSet
 * @Author lihuasong
 * @Description
 *
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);        
 * hashSet.add(2);        
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);          
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * @Date 2021-01-24 10:54
 * @Version V1.0
 **/

class MyHashSet {

    private static int LEGTH = 1000001;

    private int[] values;

    /** Initialize your data structure here. */
    public MyHashSet() {
        values = new int[LEGTH];
        for (int i = 0; i < LEGTH; i++) {
            values[i] = -1;
        }
    }

    public void add(int key) {
        values[key%LEGTH] = key;
    }

    public void remove(int key) {
        values[key%LEGTH] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return values[key%LEGTH] == key;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)); // 返回 true
        System.out.println(hashSet.contains(3)); // 返回 false (未找到)
        hashSet.add(2);
        System.out.println(hashSet.contains(2)); // 返回 true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2)); // 返回  false (已经被删除)
        System.out.println(hashSet.contains(0)); // 返回  false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */