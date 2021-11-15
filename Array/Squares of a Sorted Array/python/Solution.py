class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left = 0
        idx,right = n -1, n-1
        result = [-1] * n
        while left <= right:
            leftnum = nums[left]**2
            rightnum = nums[right]**2
            if leftnum < rightnum:
                result[idx] = rightnum
                right -= 1
            else:
                result[idx] = leftnum
                left += 1
            idx -= 1
        return result