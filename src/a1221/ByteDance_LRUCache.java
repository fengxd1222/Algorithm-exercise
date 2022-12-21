package a1221;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <a href="https://leetcode.cn/problems/lru-cache/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=yg0e3md">...</a>
 */
public class ByteDance_LRUCache {

    private Map<Integer,CacheNode> nodeMap;

    private int capacity;

    private CacheNode head;

    private CacheNode tail;

    private int defaultVal = -1;
    public ByteDance_LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new LinkedHashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(nodeMap.containsKey(key)){
            CacheNode cacheNode = nodeMap.get(key);
            CacheNode next = cacheNode.next;
            CacheNode pre = cacheNode.pre;
            next.pre = pre;
            pre.next = next;
            headInsert(cacheNode);
            return cacheNode.val;
        }
        return defaultVal;
    }

    /**
     * 头插法，但是要注意默认的链表头
     * head->1->2->3->tail  现在要在head后插入一个4
     * head->4->1->2->3->tail
     *
     * @param cacheNode
     */
    private void headInsert(CacheNode cacheNode) {
        CacheNode next = head.next;
        next.pre = cacheNode;
        cacheNode.next = next;
        cacheNode.pre = head;
        head.next = cacheNode;
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            CacheNode newNode = nodeMap.get(key);
            CacheNode next = newNode.next;
            CacheNode pre = newNode.pre;
            next.pre = pre;
            pre.next = next;
            newNode.val = value;
            headInsert(newNode);
        }else {
            if(nodeMap.size()>=capacity){
                removeLast();
            }
            CacheNode newNode = new CacheNode(value,key);
            headInsert(newNode);
            nodeMap.put(key,newNode);
        }
    }

    /**
     * 移除倒数第二个结点
     * head->1->2->3->tail 现在进来4 ，就要移除3
     * head->4->1->2->tail
     *
     * 要考虑特殊情况
     *
     * head->tail
     */
    private void removeLast() {
        CacheNode needRemove = tail.pre;
        if(needRemove ==null)return;

        if(needRemove.pre!=null){
            CacheNode pre = needRemove.pre;
            pre.next = tail;
            tail.pre = pre;
            nodeMap.remove(needRemove.key);
        }

    }

    class CacheNode{
        CacheNode pre;
        CacheNode next;
        int val;
        int key;

        public CacheNode(int val,int key) {
            this.key = key;
            this.val = val;
        }

        public CacheNode() {
        }
    }
}
