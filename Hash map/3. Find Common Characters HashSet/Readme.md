# Find Common Characters
https://leetcode.com/problems/find-common-characters/
~~~~
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

e.g.
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

e.g.
Input: words = ["cool","lock","cook"]
Output: ["c","o"]
~~~~

## idea

* Using hash table
  * lower letter
  * appear frequency
~~~
* String array 1 : [bool(a), bool(b), bool(c) ....... , bool(z)]
* String array 2 : [bool(a), bool(b), bool(c) ....... , bool(z)]
~~~

![1002.查找常用字符](https://code-thinking.cdn.bcebos.com/pics/1002.查找常用字符.png)

* Get the String array 1's character appearance frequency
~~~~
int hashMapForChar[26] = {0} 

// initialize the hash
for (int i=0; i < A[0].size; i ++) {
  //'a' index 0, rest letters has index defined by the distance to 'a'
  hashMapForChar[A[0][i] - 'a']++;  
}
~~~~

* Consolidate the frequency(appearance of each letter) 
~~~~
int hashOtherStr[26] = {0} 

for (int i=0; i < A.size(); i++){
  // initialize the hash
  for (int j=0; j < A[i].size; j ++) {
    //'a' index 0, rest letters has index defined by the distance to 'a' 
    hashOtherStr[A[i][j] - 'a']++; 
  }

  //Key !!!
  for (int k=0; k<26; k++){
    //update hash table, ensure the each letter appearance in the word is the minimum times
    hashMapForChar[k] = min(hashMapForChar[k], hashOtherStr[k])
  }
}

~~~~




