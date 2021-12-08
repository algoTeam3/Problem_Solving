import java.util.HashMap;

public class ch_완주하지못한선수 {
    private static String solution(String[] participant, String[] completions) {
        String ans = "";
        HashMap<String, Integer> hash = new HashMap<>();
        for (String p : participant) {
            hash.put(p, hash.getOrDefault(p, 0) + 1);
        }
        for (String c : completions) {
            hash.put(c, hash.get(c) - 1);
        }
        for (String k : hash.keySet()) {
            if (hash.get(k) == 1) ans = k;
        }

        return ans;
    }
}
