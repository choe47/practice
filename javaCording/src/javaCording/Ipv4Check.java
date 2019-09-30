package javaCording;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ipv4Check {
	public static void main(String[] args) {
		//file input and output
		Path infile = Paths.get("C:\\Users\\Owner\\Downloads\\ipv4a.txt");
		try (BufferedReader br = Files.newBufferedReader(infile)) {
			String ipAdress;
			while ((ipAdress = br.readLine()) != null) {
					System.out.println(ipAdress + "," + isIPAddress(ipAdress));
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
	public static boolean isIPAddress (String ipAdress) {
		String[] splitedAdress = ipAdress.split(".");
		if (splitedAdress.length != 4) {
			return false;
		}
		for(int i = 0; i < splitedAdress.length; ++i) {
			if (Integer.parseInt(splitedAdress[i]) < 0 || Integer.parseInt(splitedAdress[i]) > 255) {
				return false;
			}
		}
		return true;

	}
}