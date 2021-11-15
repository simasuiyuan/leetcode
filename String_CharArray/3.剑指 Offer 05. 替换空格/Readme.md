https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/


~~~python
class Solution:
    def replaceSpace(self, s: str) -> str:
        no_of_space = s.count(' ')
        res = list(s)
        # 每碰到一个空格就多拓展两个格子，1 + 2 = 3个位置存’%20‘
        res.extend([' '] * no_of_space * 2)

        left, right = len(s)-1, len(res)-1

        while(left >= 0):
            if res[left] != ' ':
                res[right] = res[left]
                right -= 1
            else:
                # [right-2, right-1, right] = ' ' * 3 extends for %20
                res[right-2: right+1] = '%20'
                right -= 3
            left -= 1
        return ''.join(res)
~~~