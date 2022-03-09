public class ID242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] frequencies = new int[26];
        for(char c : s.toCharArray()) frequencies[c - 'a']++;
        for(char c : t.toCharArray()) frequencies[c - 'a']--;
        for(int i : frequencies) if(i != 0) return false;
        return true;
    }
}
