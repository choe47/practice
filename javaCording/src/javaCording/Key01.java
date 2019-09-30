package javaCording;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Key01 {
	public static void main(String[] args) {
		//file input and output
		Path infile = Paths.get("C:\\Users\\Owner\\Downloads\\keynumber.txt");
		try (BufferedReader br = Files.newBufferedReader(infile)) {
			String licenseKey	;
			while ((licenseKey = br.readLine()) != null) {
					System.out.println(licenseKey + ":" + isLicense(licenseKey));
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String isLicense (String licenseKey) {
		if (licenseKey.indexOf("i") == -1 && licenseKey.indexOf("l")==-1 && licenseKey.indexOf("I")== -1 ) {
			return "OK";
		}
		return "NG";
		/*
		char[] arrayKey = licenseKey.toCharArray();
		for (int i = 0; i<arrayKey.length; ++i) { //
			switch (arrayKey[i]) {
				case 'i':
				case 'l':
				case 'I':
					return "NG"; //String java docs
			}
		}
		return "OK";
		*/
	}
	/*
	 * public int indexOf​(String str)
この文字列内で、指定された部分文字列が最初に出現する位置のインデックスを返します。
返されるインデックスは、次の式がtrueとなるような最小値kになります。


 this.startsWith(str, k)

このようなkの値が存在しない場合、-1が返されます。
パラメータ:
str - 検索対象の部分文字列。
戻り値:
指定された部分文字列が最初に出現する位置のインデックス。そのような出現箇所がない場合は-1。
	 * */

}
