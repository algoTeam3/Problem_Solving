import java.util.HashMap;
import java.util.Map;

public class oh {
    public static void main(String[] args) {
        String result = solution(new String[]{"mislav","mislav", "stanko","stanko", "mislav", "ana", "ana"}, new String[]{"mislav","stanko","stanko", "ana", "mislav", "ana"});
        System.out.println(result);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : participant) {

                map.put(s,map.getOrDefault(s,0)+1);

        }
        for (String s : completion) {
            map.put(s,map.get(s)-1);
        }
        for (String s : map.keySet()) {
            if(map.get(s)!=0){
                answer=s;
            }
        }
        return answer;
    }

}
