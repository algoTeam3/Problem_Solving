public class D8_소수만들기 {

    static int ans;
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ans = 0;
        int res = solution(nums);
        System.out.println(res);

    }

    static public int solution(int[] nums) {

        // combination
        comb(0, 0, 0, nums);


        return ans;
    }

    private static void comb(int start, int cnt, int sum, int[] nums) {

        if(cnt >= 3){
            boolean isS = true;
            for (int i = 2; i < sum; i++) {
                if(1 == sum || i == sum) break;
                if(sum%i == 0){
                    isS = false;
                    break;
                }
            }

            if(isS) ans++;
            return;
        }

        for (int i = start; i < nums.length; i++) {
            comb(i+1, cnt+1, sum+nums[i], nums);
        }

    }
}
