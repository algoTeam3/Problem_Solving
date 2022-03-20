import java.util.*;

class chan {
    public int solution(int[] nums) {

        comb(nums, 0, 0);

        return answer;
    }
    static int answer = 0;
    static int[] numbers = new int[3];
    public void comb(int[] nums, int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (isPrime(sum)) {
                answer++;
            }
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            numbers[cnt] = nums[i];
            
            comb(nums, cnt + 1, i + 1);
        }
    }
    
    public boolean isPrime(int sum) {
        boolean flag = false;
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) flag = true;
        }
        
        if (flag) return false;
        return true;
    }
}
