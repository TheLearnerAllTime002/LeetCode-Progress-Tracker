class Solution {
    public int firstUniqChar(String str) {
        int idx = -1;

    Map<Character, Integer > CharFreqMap = new HashMap<>();

    for(int i = 0; i<str.length(); i++){
        char C = str.charAt(i);

        int freq = CharFreqMap.getOrDefault(C,0);

        CharFreqMap.put (C, (freq+1));
    }

    for(int i = 0; i<str.length(); i++){
        if(CharFreqMap.get(str.charAt(i)) == 1){
            idx = i;
            break;
        }
    }
    return idx;
    }
}