package javaCording;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextCheck {
	public static void main(String[] args) {
		//file input and output
		Path infile = Paths.get("C:\\Users\\Owner\\Downloads\\abctext.txt");
		try (BufferedReader br = Files.newBufferedReader(infile)) {
			String netSlang;
			while ((netSlang = br.readLine()) != null) {
					System.out.println(netSlang + ":" + isInternetSlang(netSlang));
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// check ipv4
	/**
	 * 入力された文字列が、正しい
	 * IPアドレスならばtrueを返す。
	 * @param ipAdress
	 * @return
	 */
	public static String isInternetSlang (String netSlang) {
		String replaceString=netSlang.replace("A","4").replace("E","3").replace("G","6").replace("I","1").replace("O","0").replace("S","5").replace("Z","2");
	//	String replaceString2=netSlang.replaceAll("[AEGIOSZ]","[4361052]");
		return replaceString;
	}
}
