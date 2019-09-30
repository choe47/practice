package blog.dev.choe;

import java.util.List;

public class Test {
    public static void main(String[] args)  {

	ConnectDbms dbms = new ConnectDbms();
	String email = "saka2111@mail.com";
	String name = "saka1112";
	String pw = "1234";
	List<BlogUser> list = dbms.getBlogUser();
	for (BlogUser user : list) {
	    if (user.getUserEmail().equals(email)) {
		return;
	    }
	}
	dbms.putUser(email, name, pw);


    }
}
