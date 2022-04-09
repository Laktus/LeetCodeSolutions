import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ID347_TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> frequencies = new HashMap<>();
        for(int num : nums) frequencies.put(num, frequencies.getOrDefault(num,0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(frequencies::get).reversed());
        for(int frequency : frequencies.keySet()) {
            maxHeap.offer(frequency);
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) result[i] = maxHeap.poll();
        return result;
    }

    public static void main(String... args){
        int[] nums = {1,1,1,2,2,3};
        topKFrequent(nums, 2);
    }
}
