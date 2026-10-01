import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String word : strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            ArrayList<String> values = map.getOrDefault(key, new ArrayList<>());

            values.add(word);

            map.put(key, values);
        }

        return new ArrayList<>(map.values());

    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }
}
