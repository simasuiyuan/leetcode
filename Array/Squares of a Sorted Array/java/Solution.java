public class Solution {
    public int[] sortedSquares(int[] nums) {
        int k = nums.length-1;
        int[] sortSquareNums = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            if(nums[left]*nums[left] < nums[right]*nums[right]) {
                sortSquareNums[k--] = nums[right]*nums[right--];     
            }
            else {
                sortSquareNums[k--] = nums[left]*nums[left++];
            }
        }
        return sortSquareNums;
    }
}
