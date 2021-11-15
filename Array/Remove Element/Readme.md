# Remove Element

https://leetcode.com/problems/remove-element/

## Ieads

### Notes
* **The elements of the array are consecutive(following each other continuously) in the memory address!**
* We can only overwrite the element instead of removing it

### Two Pointers
* pointer 1 -> fast index / start
* pointer 2 -> slow index / end

#### problems
* Reverse an array **in place**.
* Given an integer array sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
* Finding cycle in Linked list
* Given a string s, find the length of the longest substring without repeating characters
* ....

#### advantage
* Conventional way -> 2 for loop -> O(n^2)
* Two pointer -> 1 for loop -> O(n)

#### implementation
![27.移除元素-双指针法](https://tva1.sinaimg.cn/large/008eGmZEly1gntrds6r59g30du09mnpd.gif)

~~~~
class Solution {
    public int removeElement(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }
}
};
~~~~