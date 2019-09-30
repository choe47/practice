package javaCording;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Practice01 {
	public static void main(String[] args) {
		Path infile = Paths.get("C:\\Users\\Owner\\Downloads\\typingtext.txt");
		try (BufferedReader br = Files.newBufferedReader(infile)) {
		// check
			String typingText;
			while ((typingText = br.readLine()) != null) {
					System.out.println(typingResult(typingText));
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static String typingResult(String originalLine) { // check
		String typingLine;
		StringBuilder resultTyping = new StringBuilder();
		//scan
		Scanner scanForm = new Scanner(System.in);
		System.out.println(originalLine);
		typingLine = scanForm.nextLine();
		scanForm.close(); //error

		//compare
		/*
		if (originalLine.length() < typingLine.length()) {
			return "too long!";
		}
		else if (originalLine.length() > typingLine.length()) {
			return "too short!";
		}
		*/

		//array
		char[] arrayTypingLine = typingLine.toCharArray();
		char[] arrayOriginalLine = originalLine.toCharArray();

		//compare2
		if (originalLine.length() < typingLine.length()) {
			for (int i=0; i<originalLine.length(); ++i) {
				if (arrayTypingLine[i]==arrayOriginalLine[i]) {
					resultTyping.append(arrayTypingLine[i]);
				}
				else {
					resultTyping.append("["+arrayTypingLine[i]+"]");
				}
			}
		}
		else {
			for (int i=0; i<typingLine.length(); ++i) {
				if (arrayTypingLine[i]==arrayOriginalLine[i]) {
					resultTyping.append(arrayTypingLine[i]);
				}
				else {
					resultTyping.append("["+arrayTypingLine[i]+"]");
				}
			}
		}
		/*
		for (int i=0; i<typingLine.length(); ++i) {
			//if (arrayTypingLine[i]==arrayOriginalLine[i]) {
			if (arrayTypingLine[i]==arrayOriginalLine[i]) {
				resultTyping.append(arrayTypingLine[i]);
			}
			else {
				resultTyping.append("["+arrayTypingLine[i]+"]");
			}
		}
		*/
		//message and return

		//print original
		System.out.println("text : "+originalLine);
		//print result
		//入力が長い
		if (originalLine.length() < typingLine.length()) {
			System.out.println("your : "+resultTyping+" : too long!");
			return "Next Chance!";
		}
		//入力が短い
		else if (originalLine.length() > typingLine.length()) {
			System.out.println("your : "+resultTyping+" : too short!");
			return "Next Chance!";
		}
		//
		else {
			//
			if (typingLine.equals(originalLine)) {
				System.out.println("your : "+typingLine);
				return "Congratuation!";
			}
			//
			else {
			System.out.println("your : "+resultTyping);
			return "Next Chance!";
			}
		}
	}
}
