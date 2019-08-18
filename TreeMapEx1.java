import java.io.*;
import java.util.*;

public class TreeMapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"A", "Z", "A", "K", "D", "K", "A", "K", "K", "K", "D", "K"};
		TreeMap map = new TreeMap<>();
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue()+1));
			} else {
				map.put(data[i], 1);
			}
		}
		Set set = map.entrySet();
		List list = new ArrayList(set);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+":"+printBar('#', value)+" "+value);
		}

		Collections.sort(list, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
					Map.Entry e1 = (Map.Entry)o1;
					Map.Entry e2 = (Map.Entry)o2;
					int v1 = ((Integer)e1.getValue()).intValue(); 
					int v2 = ((Integer)e2.getValue()).intValue();
					return v2-v1;
				}
				return -1;
			}
		});
		it = list.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+":"+printBar('#', value)+" "+value);
		}
//		for(String key:list) {
//			System.out.println(key+":"+printBar('#', map.get(key))+" "+map.get(key));
//		}
	}
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}

}
