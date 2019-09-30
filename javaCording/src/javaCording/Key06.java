package javaCording;

import java.util.Random;

public class Key06 {
	public static void main(String[] args) {
		System.out.println(newKey());
	}

	public static String newKey () {
		/*
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = upper.toLowerCase();
		String digits = "0123456789";
		String alphanum = upper + lower + digits;
		*/
		String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String errorNumber = "il0abc";
		char[] arrayNumber = errorNumber.toCharArray();
		StringBuilder licenseKey = new StringBuilder();
		Random randomNumber = new Random();
		while (licenseKey.length() < 20) {
			int index = (int) (randomNumber.nextFloat() * alphanum.length());
			for (int i=0; i<errorNumber.length(); ++i) {
				if (arrayNumber[i] == alphanum.charAt(index)) {
					continue;
				}
				else {
					licenseKey.append(alphanum.charAt(index));
					break;
				}
			}

			// System.out.println(alphanum.charAt(index)); //modify
		}
		String newLicense = licenseKey.toString();
		return newLicense;
	}
}
