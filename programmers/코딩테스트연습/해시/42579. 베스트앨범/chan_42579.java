
import java.util.*;

class chan_42579 {
    public int[] solution(String[] genres, int[] plays) {
       
        int idx = 0;
        // 1. 장르별로 재생 합 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 2. 재생 합 내림차순 저장
        List<String> orderedGenre = new ArrayList<>();
        while(map.size() > 0) {
            int max = 0;
            String maxGenre = "";
            for (String key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    maxGenre = key;
                }
            }
            orderedGenre.add(maxGenre);
            map.remove(maxGenre);
        }
        int totalSize = 0;
        for (int k = 0; k < orderedGenre.size(); k++) {
            System.out.println(orderedGenre.get(k));
            int cnt = 0;
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(orderedGenre.get(k))){
                    cnt++;
                }
            }
            if (cnt == 1) totalSize += 1;
            else totalSize += 2;
        }
        int[] answer = new int[totalSize];

        // 2. 장르별 plays 내림차순 정렬, i 오름차순 정렬
        for (int g = 0; g < orderedGenre.size(); g++) {
            List<int[]> orderedSong = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(orderedGenre.get(g))){
                    orderedSong.add(new int[]{i, plays[i]});
                }
            }

            Collections.sort(orderedSong, new Comparator<>() {
                @Override
                public int compare(int[] s1, int[] s2) {
                    // if (s2[1] - s1[1] == 0) return s1[0] - s2[0];
                    return s2[1] - s1[1];
                }
            });
            
            for (int i = 0; i < orderedSong.size(); i++) {
                if (i == 2) break;
                answer[idx++] = orderedSong.get(i)[0];
            }
        }
        

        
        // 3. 장르별로 plays 총 합 높은 순으로 고유번호 두 개씩 리턴 배열에 담기
        
        
        return answer;
    }
}
