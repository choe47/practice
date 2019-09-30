package javaCording;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Key03 {
	public static void main(String[] args) {
		//file input and output
		Path infile = Paths.get("C:\\Users\\Owner\\Downloads\\keynumber.txt");
		try (BufferedReader br = Files.newBufferedReader(infile)) {
			String licenseKey	;
			while ((licenseKey = br.readLine()) != null) {
					System.out.println(isLicense(licenseKey));
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String isLicense (String licenseKey) {
		String replaceString=licenseKey.replace("i","I").replace("l","I").replace("0","O").replace("o","O");
		return replaceString;
	}
}
