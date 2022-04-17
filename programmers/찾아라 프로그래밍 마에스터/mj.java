import java.util.HashMap;

/**
    N마리의 포켓몬 중에서 N/2마리의 포켓몬을 선택하자
    최대한 많은 종류의 포켓몬을 얻고 싶다.
 */
public class D11_포켓몬 {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        int solution = solution(nums);
        System.out.println(solution);

    }

    /**
     *
     * @param nums 포켓몬의 종류 번호가 담긴 배열. 중복 가능
     * @return 선택할 수 있는 포켓몬 종류 개수의 최댓값
     */
    private static int solution(int[] nums) {
        int answer = 0;
        int count = nums.length/2;
        // 최대 count의 포켓몬의 종류를 가져갈 수 있다.
        // 가져갈 수 있는 포켓몬의 종류를 최대한으로 가져가고 싶다.
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            if(hm.containsKey(num)){
                int cnt = hm.get(num);
                hm.replace(num, cnt+1);
            }else{
                hm.put(num, 1);
            }
        }

        // 만약 hm의 사이즈가 count보다 크면 count 만큼의 종류를 가져갈 수 있음
        if (count <= hm.size()){
            answer = count;
        }else {
            // 아니면 hm의 사이즈만큼 가져갈 수 있음
            answer = hm.size();
        }

        return answer;
    }
}
