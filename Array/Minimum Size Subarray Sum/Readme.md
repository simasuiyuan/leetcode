# Minimum Size Subarray Sum

* Given an array of positive integers nums and a positive integer target, 
* return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. 
* If there is no such subarray, return 0 instead.

### Example 1:
~~~~
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
~~~~

### Example 2:
~~~~
Input: target = 4, nums = [1,4,4]
Output: 1
~~~~

### Example 2:
~~~~
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
~~~~

### Constraints:
* 1 <= target <= 109
* 1 <= nums.length <= 105
* 1 <= nums[i] <= 105

## Implementation
### Trival solution - double for loop :(
* **O(n^2)**

~~~~
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int i=0; i < nums.length; i++) {
            sum=0;
            for (int j=i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    if (result > subLength) {
                        result = subLength;
                        break;
                    }
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}
~~~~

### Advanced solution - sliding window :) (2 pointers)

#### sliding window
* Constantly adjust the start and end positions of the subsequence
* Question to ask:
  * whats **inside** the window ?
    * sum within window >= target -> with least length of subsequence
  * how to move start position (pointer 1) ?
    * if sum(within window) > target -> move start forward -> shrink window
  * how to move end position (pointer 2) ?
    * scan indices starts from start pointer
* **O(n)!**

![209.长度最小的子数组](https://code-thinking.cdn.bcebos.com/gifs/209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.gif)

![leetcode_209](https://img-blog.csdnimg.cn/20210312160441942.png)

~~~~

~~~~