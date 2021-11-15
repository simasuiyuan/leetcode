class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length==0) return result;
        int[] hashTable = new int[26];
        
        for (int i=0;i<words[0].length(); i++){
            hashTable[words[0].charAt(i) - 'a']++; //initialization
        }
        
        for (int i=0; i<words.length; i++){
            int[] hashOtherStr= new int[26];
            for (int j=0; j<words[i].length(); j++){
                hashOtherStr[words[i].charAt(j) - 'a']++;
            }
            
            for (int k=0; k<26; k++){
                hashTable[k] = Math.min(hashTable[k], hashOtherStr[k]);
            }
        }
        
        // Formating hashTable result frequency to output format
        for (int i=0; i < 26; i++){
            while(hashTable[i] != 0){
                char c = (char) (i+'a');
                result.add(String.valueOf(c));
                hashTable[i]--;
            }
        }
        
        return result;
    }
}