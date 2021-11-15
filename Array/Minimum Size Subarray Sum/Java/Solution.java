public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        int sum = 0;
        int subLength = 0;
        for (int i=0; i < nums.length; i++) {
            sum=0;
            for (int j=i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
                    System.out.println("subLength: " + subLength);
                    System.out.println("result: " + result);
                    subLength = j - i + 1;
                    if (result > subLength) {
                        result = subLength;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
