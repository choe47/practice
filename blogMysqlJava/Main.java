package choe.practice;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ConnectDbms dbms = new ConnectDbms();
		String mail = "noah@gmail.com";
		String typePassword = "melonjuice";
		int myId = 0;

		String myPassword = dbms.getPasswordFromEmail(mail);

		if (typePassword.equals(myPassword)) {
			myId = dbms.getUserId(mail, myPassword);
		}

		String text = "1st blog post content in line blah blah blah";
		String text1 = "2nd blog post content in line blah blah blah";
		String text2 = "3rd blog post content in line blah blah blah";

		dbms.putPost(myId, text);
		dbms.putPost(myId, text1);
		dbms.putPost(myId, text2);

		List<String> list = dbms.getPost(myId);
		System.out.println(list);


	}

}
