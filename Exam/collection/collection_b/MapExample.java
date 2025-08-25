package collection.collection_b;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("blue", 96);
        map.put("hing", 86);
        map.put("white", 92);
        
        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> item : set) {
            if(item.getValue() > maxScore) {
                maxScore = item.getValue();
                name = item.getKey();
            }
            totalScore += item.getValue();
        }
        totalScore = totalScore / map.size();
        System.out.println("최고 점수: " + maxScore + "\t" + "최고 점수 이름: " + name);
        System.out.println("평균 점수: " + totalScore);
    }
}
