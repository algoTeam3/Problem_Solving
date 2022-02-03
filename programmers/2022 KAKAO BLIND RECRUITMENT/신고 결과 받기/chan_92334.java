import java.util.*;

class chan_92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> idList = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (String id : id_list) {
            idList.put(id, new HashSet<>());
            count.put(id, 0);
        }
        for (String r : report) {
            String[] data = r.split(" ");
            idList.get(data[1]).add(data[0]);
        }
        for (String key : idList.keySet()) {
            HashSet<String> reportId = idList.get(key);
            if (reportId.size() >= k) {
                for (String n : reportId) {
                  count.put(n, count.get(n) + 1);
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.get(id_list[i]);
        }
        return answer;
    }
}