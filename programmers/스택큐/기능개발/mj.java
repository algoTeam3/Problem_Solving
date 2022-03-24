import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D7_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
//        int[] ans = solution(progresses, speeds);
//        System.out.println(Arrays.toString(ans));
        int[] ans = solution2(progresses, speeds);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int day = 1;
            // 몇번째 날에 100을 넘는지 알기 위해서
            while(progresses[i]+ (day*speeds[i]) < 100){
                day++;
            }
            // 해당 기능이 몇번째 날에 끝나는지 구한다.
            q.offer(day);
        }

        int res = q.poll();
        int n = 1;
        while(!q.isEmpty()){
            if(q.peek() <= res){
                n++;
                q.poll();
            }else{
                list.add(n);
                n = 1;
                res = q.poll();
            }
        }
        list.add(n);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> list = new LinkedList<>();
        // 여태 배포된 기능 개수
        int cnt = 0;
        while(cnt < progresses.length){
            // 배포될 기능 개수
            int n = 0;
            // 배포 하지 않은 기능 중 첫번째 기능의 배포 여부
            boolean distribute = false;
            // progress 증가
            for (int i = cnt; i < progresses.length; i++) {
                if (progresses[i] >= 100) continue;
                progresses[i] += speeds[i];
            }

            // 먼저 있는 기능이 완료 되었을 때
            if(progresses[cnt] >= 100){
                distribute = true;
            }

            for (int i = cnt; i < progresses.length; i++) {
                // 배포 하지 않은 기능 중 첫번째 기능의 배포 여부
                if(distribute){
                    // 배포 포함 되는 기능 개수 세던 중 100 이하인 기능이 있으면 멈추기 아니면 개수 증가
                    if(progresses[i] < 100){
                        break;
                    }else{
                        n++;
                    }
                }
            }

            if (n != 0){
                list.add(n);
            }

            // 여태 포함된 기능의 개수 더하기
            cnt += n;

        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
