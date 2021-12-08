import java.util.HashMap;

class chan_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        /**
         * HashMap은 Map Collection중 하나
         * Map은 키-값으로 저장
         * - 키는 중복 X
         * - 값은 중복 O
         */
        HashMap<String, Integer> hm = new HashMap<> ();
        for(String par : participant)
            hm.put(par, hm.getOrDefault(par, 0) + 1);
        
        for(String com : completion)
            hm.put(com, hm.get(com) - 1);
        
        for(String key : hm.keySet())
            if(hm.get(key) != 0)
                answer = key;
        
        return answer;
    }
}