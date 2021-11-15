# Squares of a Sorted Array

### Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

#### Example
~~~~
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
~~~~

#### Constraints
* 1 <= nums.length <= 104
* -104 <= nums[i] <= 104
* nums is sorted in non-decreasing order.

## Implementation

### Trival solution: square -> sort

~~~~
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            nums[i] *= nums[i]
        }
        Arrays.sort(nums);
        return nums;
    }
}
~~~~

* Time Complexity : **O(n + nlogn)**

### Efficient solution: 2 pointers!

* **The original array is sorted!** -> [smallest neg, ......, largest pos]
* After square all nums in array -> [(large pos)neg, ... ,(small pos), ..., (large pos)pos]
* pointer 1 -> 0 (start); pointer 2 -> -1 (end)
* nums[pt1] <?> nums[pt2] -> larger number -> left
* pt1 > pt2 -> stop


![](https://code-thinking.cdn.bcebos.com/gifs/977.有序数组的平方.gif)
~~~~
class Solution {
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
~~~~