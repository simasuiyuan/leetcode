# Binary Search
* https://leetcode.com/problems/binary-search/

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:     

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4    
```

Example 2: 

```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1    
```

Constraints: 

* 1 <= nums.length <= 104
* -104 < nums[i], target < 104
* All the integers in nums are **unique**.
* nums is sorted in ascending order.


## Ieads

### Binary search prerequisite
* O(log n)
* nums is sorted in **ascending order** & nums are **unique** => Binary Search
* if not unique => Binary search => non unique index

### Binary search implementation
* Confusion point => while(left < right)? while(left <= right)?; right = middle? right = middle-1?
* The definition of **interval**! => invariant
* **invariant**: An invariant is any logical rule that must be obeyed throughout the execution of your program that can be communicated to a human, but not to your compiler
* e.g. the definition of the `[left, right]` or `[left, right)` in Binary search
* In Binary search, every iteration in while loop looking for interval, should strictly follow the determined interval (either `[left, right]` or `[left, right)`) to operate => L**oop invariant**

#### implementation 1 (interval: `[left, right]`)
* **Note: `[left, right]` definition is very important!**
* implementation
  1. `whlile(left <= right)` ; Note: `<=` is the key! 
     * because `left == right` is meaningful!
  2. `if(nums[middle]) > target` -> `right = middle - 1` 
     * because `nums[middle]) > target` -> number @ middle is not target & target should before middle
     * thus propose middle -1
~~~
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) -1 # define target in [left, right], here right is a valid index
        while(left<=right): # when left==right, interval [left, right] is valid 
            middle = (left + right)//2
            if (nums[middle] > target):
                right = middle - 1 # target in [left, right-1]
            elif (nums[middle] < target):
                left = middle + 1 # target in [left + 1, right]
            else:
                return middle
        return -1
~~~


#### implementation 2 (interval: `[left, right)`)
* **Note: `[left, right)` definition is very important!**
* implementation
  1. `whlile(left < right)` ; Note: `<` is the key! 
     * because `left == right` is not valid!
  2. `if(nums[middle]) > target` -> `right = middle - 1` 
     * because `nums[middle]) > target` -> number @ middle != target 
     * -> since `left == right` is invalid -> which `right = middle` -> the `nums[middle]` wont be checked in next comparision
~~~
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) -1 # define target in [left, right], here right is a valid index
        while(left<=right): # when left==right, interval [left, right] is valid 
            middle = (left + right)//2
            if (nums[middle] > target):
                right = middle - 1 # target in [left, right-1]
            elif (nums[middle] < target):
                left = middle + 1 # target in [left + 1, right]
            else:
                return middle
        return -1
~~~