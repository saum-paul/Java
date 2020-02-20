package org.smacknologs.patterns.expressiontree.factory;

import java.util.HashMap;
import java.util.Map;

public class PathFactory {

	private Map<String, PathFactoryAPI> patternMap;

	public PathFactory() {
		patternMap = new HashMap<>();
		patternMap.put("checks",
				(param) -> param.getSequence().substring(0, 4) + "/" + param.getDate().substring(3, 6));
	}

	private interface PathFactoryAPI {
		String makePath(Item s);
	}

	public String makePath(String type, Item c) {
		return patternMap.get(type).makePath(c);
	}
}
