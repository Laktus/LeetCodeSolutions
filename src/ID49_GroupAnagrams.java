import java.util.*;

public class ID49_GroupAnagrams {
    public static void main(String... args){
        String[] ex1 = {"eat","tea","tan","ate","nat","bat"};
        String[] ex2 = {""};
        String[] ex3 = {"a"};

        List<List<String>> ex1r = groupAnagrams(ex1);
        List<List<String>> ex2r = groupAnagrams(ex2);
        List<List<String>> ex3r = groupAnagrams(ex3);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] frequencyTable = frequencyTable(str);
            map.putIfAbsent(Arrays.hashCode(frequencyTable), new ArrayList<>());
            map.get(Arrays.hashCode(frequencyTable)).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(Integer key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }

    private static int[] frequencyTable(String str){
        int[] frequencyTable = new int[26];
        for(char c : str.toCharArray()) frequencyTable[c - 'a']++;
        return frequencyTable;
    }
}
