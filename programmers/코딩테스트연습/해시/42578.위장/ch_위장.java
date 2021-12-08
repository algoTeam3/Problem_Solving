import java.util.HashMap;

public class ch_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();

        for(int i =0; i<clothes.length; i++){
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0)+1);
        }

        for(Integer cnt : hash.values()) {
            answer *= cnt + 1;
        }
        return answer - 1;
    }
}
