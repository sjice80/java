import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;

public class TreeMapEx2 {
	public static void main(String[] args) {
		int[] data = {45, 53, 39, 80, 90, 67, 80, 53, 56, 75, 45, 45, 53, 45};
		System.out.println(solution(data));
	}
	public static int solution(int[] weights) {
		int answer = 0;
		TreeMap<Integer, ArrayList<Integer>> weightMap = new TreeMap<>();
		for(int weight : weights) {
			if(weightMap.containsKey(weight)) {
				weightMap.get(weight).add(1);
			} else {
				ArrayList<Integer> weightList = new ArrayList<>();
				weightList.add(1);
				weightMap.put(weight, weightList);
			}
		}
		Set<Integer> keys = weightMap.keySet();
		for(int key : keys) {
			System.out.println(key + "," + weightMap.get(key));
		}
		while(weightMap.size()>0) {
			int weight = weightMap.firstKey();
			System.out.println("weight:"+weight);
			ArrayList<Integer> weightList = weightMap.remove(weight);
			System.out.println(weightMap);
			Collections.sort(weightList, Collections.reverseOrder());
			System.out.println("역순:"+weightList);
			for(int i=0; i<weightList.size(); i+=2) {
				if(i+1<weightList.size()) {
					int sum = weightList.get(i) + weightList.get(i+1);
					answer = Math.max(answer, sum);
					if(weightMap.containsKey(2*weight)) {
						weightMap.get(2*weight).add(sum);
					} else {
						ArrayList<Integer> newWeightList = new ArrayList<>();
						newWeightList.add(sum);
						weightMap.put(2*weight, newWeightList);
					}
				} else {
					answer = Math.max(answer, weightList.get(i));
				}
			}
		}
		return answer;
	}
}
