import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class chan_42578 {
    public int solution(String[][] clothes) {
        int answer = 0;
        int value = 1;
        int combination = 1;
        HashMap<String, Integer> clomap = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
            if(clomap.containsKey(clothes[i][1]))
                value = clomap.get(clothes[i][1]) + 1;
            clomap.put(clothes[i][1], value);
            value = 1;
        }

        Collection<Integer> values = clomap.values();
        for(Integer a : values){
            combination *= (a + 1);
        }
        answer = combination - 1;
        
        return answer;
    }
}
