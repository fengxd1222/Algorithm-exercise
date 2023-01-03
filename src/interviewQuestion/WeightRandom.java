package interviewQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.*;

public class WeightRandom<T> {
    private final TreeMap<Integer, T> weightMap;

    /**
     * 创建权重随机获取器
     *
     * @param <T> 权重随机获取的对象类型
     * @return {@link WeightRandom}
     */
    public static <T> WeightRandom<T> create() {
        return new WeightRandom<>();
    }

    /**
     * 构造
     */
    private WeightRandom() {
        weightMap = new TreeMap<>();
    }

    /**
     * 增加对象
     *
     * @param obj 对象
     * @param weight 权重
     */
    public void add(T obj, int weight) {
        if (weight > 0) {
            int lastWeight = (this.weightMap.size() == 0) ? 0 : this.weightMap.lastKey();
            this.weightMap.put(weight + lastWeight, obj);// 权重累加
        }
    }

    /**
     * 清空权重表
     */
    public void clear() {
        this.weightMap.clear();
    }

    /**
     * 下一个随机对象
     *
     * @return 随机对象
     */
    public T next() {
        int randomWeight = (int) (this.weightMap.lastKey() * Math.random());
        SortedMap<Integer, T> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

    public static void main(String[] args) {
        WeightRandom<String> weightRandom = WeightRandom.create();
        weightRandom.add("A", 50);
        weightRandom.add("B", 20);
        weightRandom.add("C", 30);
        testRate(weightRandom);
    }

    private static void testRate(WeightRandom<String> weightRandom) {
        Map<String, Integer> countMap = new ConcurrentHashMap<>();
        int total = 100_000_00;

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(total));
        //2、这里传入的参数是Runnable接口实现类的对象，并调用execute()方法

        for (int i = 0; i < total; i++) {
            threadPool.submit(()->{
                String randomKey = weightRandom.next();
                countMap.put(randomKey, countMap.getOrDefault(randomKey, 0) + 1);
            });
        }
        threadPool.shutdown();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(String.format("%s count: %s,freq: %s", entry.getKey(), entry.getValue(),
                    1.0 * entry.getValue() / total));
        }
    }
}
