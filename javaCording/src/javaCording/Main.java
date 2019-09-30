package javaCording;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		String key = "apple";
		String value = "green";
		String key1 = "apple1";
		String value1 = "green1";
		String key2 = "apple2";
		String value2 = "green2";
		String key3 = "apple3";
		String value3 = "green3";
		String key4 = "apple4";
		String value4 = "green4";
		String key5 = "apple5";
		String value5 = "green5";
		String key6 = "apple6";
		String value6 = "green6";
		String key7 = "apple7";
		String value7 = "green7";

		ArrayListMap map = new ArrayListMap();
		String[] newKeys = map.keys();
		String[] newValues = map.values();
		//test01
		System.out.println(map.get("apple1"));
		System.out.println(Arrays.toString(newKeys));
		System.out.println(Arrays.toString(newValues));
		//add
		map.add(key, value);
		map.add(key1, value1);
		map.add(key2, value2);
		map.add(key3, value3);
		map.add(key4, value4);
		map.add(key5, value5);
		map.add(key6, value6);
		map.add(key7, value7);
		map.add(key1, value1);
		map.add(key5, value3);
		//test02
		newKeys = map.keys();
		newValues = map.values();
		System.out.println(Arrays.toString(newKeys));
		System.out.println(Arrays.toString(newValues));
		System.out.println(map.get("apple7"));
		//test03
		newKeys = map.keys();
		newValues = map.values();
		System.out.println(Arrays.toString(newKeys));
		System.out.println(Arrays.toString(newValues));
	}
}