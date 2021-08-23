import java.util.LinkedList;
import java.util.Queue;

public class programmers_lv2_기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int start = 0;
        
        while (true) {
        	// 상단 요소의 작업 진도가 100이상일 때까지
            while (progresses[start] < 100) {
                for (int i = start; i < progresses.length; i++) {
                	if (progresses[i] >= 100) continue;
                	// 작업 추가
                    progresses[i] += speeds[i];
                }
            }
            
            int cnt = 0;
            boolean flag = false;
            for (int i = start; i < progresses.length; i++) {
            	// 작업 진도가 100이상이면 cnt+1
                if (progresses[i] >= 100) {
                	cnt++;
                	if (i == progresses.length - 1) flag = true;
                }
                // 작업 진도가 100미만이면 해당 기점으로 다시 작업 진행
                else {
                	start = i;
                	break;
                }
            }
            // 완성된 기능의 개수 queue에 offer
            queue.offer(cnt);
            // 마지막 기능까지 마쳤으면 반복문 탈출
            if (flag) break;
        }
        
        int[] answer = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) answer[i++] = queue.poll();
        for (int num : answer) {
        	System.out.print(num + " ");
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		solution(progresses, speeds);
	}
}
