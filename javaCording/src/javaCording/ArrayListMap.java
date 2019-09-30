package javaCording;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMap {

	private List<String> keys = new ArrayList<>();
	private List<String> values = new ArrayList<>();
	private int maxSize = 5;

	/**
	*	LRU Cache : add
	*
	*
	*/
	public void add(String key, String value) {
		for (int i = 0; i < keys.size(); ++i) {
			if (keys.get(i).equals(key)) {
				keys.remove(i);
				values.remove(i);
			}
		}
		keys.add(key);
		values.add(value);
		if (keys.size() <= maxSize) {
			return;
		} else {
			for (int j = 0; j < maxSize; ++j) {
				keys.set(j, keys.get(j + 1));
				values.set(j, values.get(j + 1));
			}
		}
		keys.remove(maxSize);
		values.remove(maxSize);
		return;
	}

	/**
	*	LRU Cache : get
	*
	*
	*/
	public String get(String key) {
		for (int i = 0; i < keys.size(); ++i) {
			if (keys.get(i).equals(key)) {
				String copyKey = keys.get(i);
				String copyValue = values.get(i);
				for (int j = i; j < maxSize - 1; j++) {
					keys.set(j, keys.get(j + 1));
					values.set(j, values.get(j + 1));
				}
				keys.set(maxSize - 1, copyKey);
				values.set(maxSize - 1, copyValue);
				return values.get(maxSize - 1);
			}
		}
		return null;
	}

	//全てのkeyを取り出す
	public String[] keys() {
		String[] newArray = keys.toArray(new String[0]);
		return newArray;
	}

	//全てのvalueを取り出す
	public String[] values() {
		String[] newValues = values.toArray(new String[0]);
		return newValues;
	}

	//データ数を取り出す
	public int size() {
		return keys.size();
	}
}
