import java.util.HashMap;
import java.util.Map;

public class oh {
    public static void main(String[] args) {
        int result = solution(new String[][]{{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}});
        System.out.println(result);
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        for(String keys: map.keySet()) {
            answer *= (map.get(keys) + 1);
        }

        answer -= 1;

        return answer;
    }
}
