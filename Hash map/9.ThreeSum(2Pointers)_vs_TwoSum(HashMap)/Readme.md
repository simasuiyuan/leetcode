# 15. 3Sum

## Leetcode Problem

~~~~
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.


Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]

Example 2:
    Input: nums = []
    Output: []
~~~~

## Using Unordered Hash set (Not recommanded for 3 SUM)

* Reason why Unordered Hash set not good for 3Sum

  * O(n^2)
  * **Duplicates redudant is complcated !**
* Steps:

  * Sort the array
  * Duplicates redudant
    * if nums[starts] > 0; since all later numer will > 0 => no more combination later will sum to 0 =>  continue
    * if starts > 0 && nums[starts] == nums[starts_previous] => all the combination start with nums[starts] already been checked => continue

  ~~~~~~cpp
  class Solution {
  public:
      vector<vector<int>> threeSum(vector<int>& nums) {
          vector<vector<int>> result;
          sort(nums.begin(), nums.end());
          // 找出a + b + c = 0
          // a = nums[i], b = nums[j], c = -(a + b)
          for (int i = 0; i < nums.size(); i++) {
              // 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
              if (nums[i] > 0) {
                  continue;
              }
              if (i > 0 && nums[i] == nums[i - 1]) { //三元组元素a去重
                  continue;
              }
              unordered_set<int> set;
              for (int j = i + 1; j < nums.size(); j++) {
                  if (j > i + 2
                          && nums[j] == nums[j-1]
                          && nums[j-1] == nums[j-2]) { // 三元组元素b去重
                      continue;
                  }
                  int c = 0 - (nums[i] + nums[j]);
                  if (set.find(c) != set.end()) {
                      result.push_back({nums[i], nums[j], c});
                      set.erase(c);// 三元组元素c去重
                  } else {
                      set.insert(nums[j]);
                  }
              }
          }
          return result;
      }
  };

  ~~~~~~
  ## Using 2 Pointers (Recommanded!)
* More efficient ( still O(n^2))
* ![15.三数之和](https://code-thinking.cdn.bcebos.com/gifs/15.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.gif)
* Sort nums
* nums[i]; left; right
  * for over i => starts index
  * left starts from i+1
* find nums[i] + nums[left] + nums[right] == 0
* if nums[i] + nums[left] + nums[right] > 0 => right shift to left 1 pos
* if nums[i] + nums[left] + nums[right] < 0 => left shift to right 1 pos
* until left == right

~~~~java
import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-2; i++){
            if(nums[i] >0){
                // rest combination will all be +ve
                return result;
            }
            if(i>0 && nums[i] == nums[i-1]){
                // already been check, duplicates
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                } else if (sum > 0){
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while(right > left && nums[right] ==  nums[right - 1]) right--; // in case right has duplicates; skip
                    while(right > left && nums[left] ==  nums[left + 1]) left++; // in case left has duplicates; skip
                    
                    right--;
                    left++;
                }
            }
        }
        
        return result;
    }
}
~~~~

# important!: why 3Sum question can use 2 pointers; but 2 sum cannot?
1. 2 sum asks to return index of the number; 3 sum asks exact numbers
2. for 2 sum return index, if we sort the array, the indies will be changed!
3. if 2 sum ask for numbers, we still can use 2 pointers