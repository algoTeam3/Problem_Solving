import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Programmers_lv3_베스트앨범 {
	
	public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hash = new HashMap<>();	// 장르별 재생횟수 저장
        ArrayList<String> bestGenre = new ArrayList<>();	// 재생횟수 많은 순으로 장르 저장
        ArrayList<Integer> answer = new ArrayList<>();		// 인덱스를 저장할 List
        for (int i = 0; i < genres.length; i++) {
        	String genre = genres[i];
        	// 장르 중복 O
        	if (hash.containsKey(genre)) hash.put(genre, hash.get(genre) + plays[i]);
        	// 장르 중복 X
        	else hash.put(genre, plays[i]);
        }
        
        // 장르별 재생횟수 내림차순 정렬
        List<String> key = new ArrayList<>(hash.keySet());
        Collections.sort(key, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));
		
        // 재생횟수 많은 순으로 장르 저장
        for (String genre : key) {
        	bestGenre.add(genre);
        }
        
        for (int i = 0; i < bestGenre.size(); i++) {
        	String genre = bestGenre.get(i);
        	int idx = 0;	// 인덱스
        	int max = 0;	// 재생횟수
        	// 해당 장르에서 가장 많이 재생된 고유번호 구하기
        	for (int j = 0; j < genres.length; j++) {
        		if (genres[j].equals(genre)) {
        			if (max < plays[j]) {
        				max = plays[j];
        				idx = j;
        			}
        		}
        	}
        	// answer에 저장
        	answer.add(idx);
        	// 재생횟수 -1로 변경
        	plays[idx] = -1;
        	// 최댓값 초기화
        	max = 0;
        	
        	// 해당 장르에서 두번째로 많이 재생된 고유번호 구하기
        	for (int j = 0; j < genres.length; j++) {
        		if (genres[j].equals(genre)) {
        			if (max < plays[j]) {
        				max = plays[j];
        				idx = j;
        			}
        		}
        	}
        	// 두번째로 많이 재생된 고유번호가 존재한다면 answer에 저장
        	if (max != 0) answer.add(idx);
        }
        
        // 정답 List를 배열에 옮기기
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
        	result[i] = answer.get(i);
        }
        
        // 출력
        return result;
    }
}
