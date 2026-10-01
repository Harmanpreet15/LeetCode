import java.util.*;

public class TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert map entries into list

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];

        for(int i=0; i<k; i++){
            result[i] = entries.get(i).getKey();
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // System.out.println(topKFrequent(nums, k));
        // this gives us memory address as list is not printed by simply println

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
