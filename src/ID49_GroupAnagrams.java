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

    class Point{
        public final int x;
        public final int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public double distance(){
            return Math.sqrt(x * x + y * y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>(Comparator.comparingDouble(Point::distance));

        double min = Double.MAX_VALUE;
        for(int[] point : points){
            minHeap.add(new Point(point[0], point[1]));
        }

        int[][] result = new int[k][2];
        for(int i = 0; minHeap.size() != 0 && i < k; i++){
            Point p = minHeap.poll();
            result[i] = new int[]{p.x,p.y};
        }

        return result;
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
