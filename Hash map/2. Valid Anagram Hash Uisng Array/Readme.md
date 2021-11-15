# Array is the simplest hash table, but the size of array is limited!

## Valid Anagram
#### whats Anagram? : different words but contain same letters with different arrange

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
~~~~
Input: s = "anagram", t = "nagaram"
Output: true
~~~~

Example 2:
~~~~
Input: s = "rat", t = "car"
Output: false
~~~~

# idea

### 1. Using hash table with size 26 (A~Z) to register the occurrence of each alphabet in s, 
### 2. Then check through t, evey occurrence of letter subtract corresponding count by on in record hash table
![242.有效的字母异位词](https://tva1.sinaimg.cn/large/008eGmZEly1govxyg83bng30ds09ob29.gif)

### 3. How to encode letter to index?
#### we can register the relative distance from letter s[i] to 'a'
~~~~
record[s[i]-'a'] ++;
record[t[i]-'a'] --;
~~~~

~~~~
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c: s.toCharArray()) {
            record[c-'a'] += 1;
        }
        for (char c: t.toCharArray()) {
            record[c-'a'] -= 1;
        }
        for (int i: record) {
            if(i!=0) {
                return false;
            }
        }
        return true;
    }
}
~~~~