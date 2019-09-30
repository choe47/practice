package practicechoe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckAdress {
	public static void main(String[] args) {
		//file input and output
		Path infile = Paths.get("C:\\Users\\Owner\\Downloads\\ipv4a.txt");
		Path outfile = Paths.get("C:\\Users\\Owner\\Downloads\\checkipv4a.txt");
		try (BufferedReader br = Files.newBufferedReader(infile);
			BufferedWriter bw = Files.newBufferedWriter(outfile)) {
			String ipAdress;
			while ((ipAdress = br.readLine()) != null) {
				String res;
				if((res = checkIp(ipAdress)) != null) {
					bw.write(res);
					System.out.println(res);
				}
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// check ipv4
	@SuppressWarnings("unused")
	public static String checkIp (String ipAdress) {
		String[] splitedAdress = ipAdress.split(".");
		int[] intAdress = new int[splitedAdress.length];
		for (int i = 0; i<=3; i++) {
			if (intAdress[i] >= 0 && intAdress[i] <= 255 && intAdress.length == 4) {
			return(ipAdress+",ture");
			} else {
			return(ipAdress+",false");
			}
		}
		return ipAdress;
	}
}
