import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapSum
 * @Author lihuasong
 * @Description
 * @Date 2021-11-14 19:22
 * @Version V1.0
 **/

class MapSum {
    Map<String,Integer> data;
    public MapSum() {
        data = new HashMap<>();
    }

    public void insert(String key, int val) {
        data.put(key,data.getOrDefault(key,0)+val);
    }

    public int sum(String prefix) {
        return data.entrySet().stream().filter(x->x.getKey().startsWith(prefix)).mapToInt(Map.Entry::getValue).sum();
    }
}
