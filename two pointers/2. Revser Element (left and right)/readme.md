# 2 pointers left and right

## reference https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0344.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.md

## problem: https://leetcode.com/problems/reverse-string/


~~~python
class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        left = 0
        right = len(s) - 1
        while left<right:
            s[left],s[right] = s[right],s[left]
            left += 1
            right -= 1
~~~