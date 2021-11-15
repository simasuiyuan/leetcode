
https://leetcode.com/problems/reverse-string/

~~~java
class Solution {
    public void reverseString(char[] s) {
        //using 2 pointer
        int left = 0;
        int right = s.length-1;
        while(left < right){
            s[left] ^= s[right]; // let a' = a^b
            s[right] ^= s[left]; // let b' = b^a' = b^(a^b) = a
            s[left] ^= s[right]; // let a = a'^b' = (a^b)^a = b
            
            left++;
            right--;
        }
    }
}
~~~