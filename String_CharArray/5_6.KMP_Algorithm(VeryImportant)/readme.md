https://leetcode.com/problems/implement-strstr/

# Pattern search
## reference: !!!!! https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md

~~~python
class Solution(object):
    def getNext(self, needle):
        j = -1
        Next = [-1]
        for i in range(1,len(needle)):
            while(j>=0 and needle[i]!=needle[j+1]): 
                j = Next[j]
            if(needle[i]==needle[j+1]):
                j += 1
            Next.append(j)
        return Next
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        j = -1
        if len(needle) == 0 : return 0
        Next = self.getNext(needle)
        for i in range(len(haystack)):
            while(j>=0 and haystack[i]!=needle[j+1]):
                j = Next[j]
            if(haystack[i]==needle[j+1]):
                j += 1
            if(j==len(needle)-1):
                return (i - len(needle) + 1)
        return -1
~~~


# repeated Pattern search
## reference: !!!!! https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0459.%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.md

~~~python
class Solution(object):
    def getNext(self, pattern):
        j = -1
        Next = [j]
        for i in range(1, len(pattern)):
            while(j>=0 and pattern[i]!=pattern[j+1]):
                j = Next[j]
            if pattern[i]==pattern[j+1]:
                j += 1
            Next.append(j)
        return Next
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        Next = self.getNext(s)
        if Next[-1] != -1 and (len(s) % (len(s)-(Next[-1]+1)) == 0):
            return True
        else:
            return False
~~~