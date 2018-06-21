package codecheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		List<Integer> keyList = new ArrayList<Integer>();
		Map<Integer, String> labelMap = new HashMap<Integer, String>();

		for (int i = 0, l = args.length - 1; i < l; i++) {
			String[] pair = args[i].split(":");
			Integer key = Integer.parseInt(pair[0]);
			keyList.add(key);
			labelMap.put(key, pair[1]);
		}
		Collections.sort(keyList);

		int target = Integer.parseInt(args[args.length - 1]);
		StringBuilder sb = new StringBuilder();
		for (Integer key: keyList) {
			if (target % key == 0) {
				sb.append(labelMap.get(key));
			}
		}
		if (sb.toString().isEmpty()) {
			sb.append(target);
		}

		System.out.println(sb.toString());
	}
}
