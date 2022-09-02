package codeSignal.prep;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

public class SwapLexOrder {
    public static void main(String[] args) {
        var str = "acxrabdz";
        var pairs = new int[][] { new int[] { 1,3 }, new int[] { 6,8 }, new int[] { 3,8 }, new int[] { 2,7 } };
        System.out.println(solution(str, pairs));
    }

    static String solution(String str, int[][] pairs) {
        if (str == null) {
            return "";
        }
        if (pairs.length == 0) {
            return str;
        }
        // use a hashmap as a queue
        var map = new HashMap<String,Boolean>();
        var a = str.toCharArray();
		while(true) {
			int counter = 0;
            // for each pair calculate the swap
			for(var p: pairs) {
				String swapped = swap(a, p);
				if(map.containsKey(swapped))
					continue;
				map.put(new String(a), true);
				counter++;
			}
			if(counter == 0)
				break;
		}
		var list = Arrays.asList(map.keySet().toArray(new String[0]));
		map.clear();
        // get the largest string lexicographically
		Collections.sort(list);
		return list.get(list.size()-1);
    }

	static String swap(char a[], int[] pair) {
        if(pair[0]-1 < 0 || pair[1]-1 < 0 || pair[0]-1 >= a.length || pair[1]-1 >= a.length) {
            return new String(a);
        }
		char tmp = a[pair[0]-1];
		a[pair[0]-1] = a[pair[1]-1];
		a[pair[1]-1] = tmp;
		return new String(a);
	}

}
