import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ch_베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashgenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            hashgenres.put(genres[i], hashgenres.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> keylist = new ArrayList<>();
        for (String key :
                hashgenres.keySet()) {
            keylist.add(key);
        }
        Collections.sort(keylist, (o1, o2) -> hashgenres.get(o2) - hashgenres.get(o1));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < keylist.size(); i++) {
            String g = keylist.get(i);

            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && max < plays[j]){
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && max < plays[j] && j != firstIdx){
                    max = plays[j];
                    secondIdx = j;
                }
            }
            list.add(firstIdx);
            if (secondIdx >= 0) list.add(secondIdx);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
