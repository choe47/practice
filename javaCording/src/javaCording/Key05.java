package javaCording;

import java.util.Random;

public class Key05 {
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
		String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghjkmnopqrstuvwxyz123456789";
		StringBuilder licenseKey = new StringBuilder();
		Random randomNumber = new Random();
		while (licenseKey.length() < 20) {
			int index = (int) (randomNumber.nextFloat() * alphanum.length());
			licenseKey.append(alphanum.charAt(index));
		}
		String newLicense = licenseKey.toString();
		return newLicense;
	}

}
