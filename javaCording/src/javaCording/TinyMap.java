package javaCording;

import java.util.HashMap;
import java.util.Map;

public class TinyMap {

	Map<String, String> map = new HashMap<String, String>();

	public TinyMap(String key, String value) {

	}

	public void add(String key, String value) {
		map.put(key, value);
	}

	public String get(String key){
		return (map.get(key));
	}

	//全てのkeyを取り出す
	public String[] keys() {
		for(String key :map.keySet()) {
			System.out.println(key);
		}
		return null;
	}
	//全てのvalueを取り出す
	public String[] values() {
		for(String key :map.keySet()) {
			System.out.println(map.get(key));
		}
		return null;
	}

	//データ数を取り出す
	public int size() {
		return map.size();
	}

}