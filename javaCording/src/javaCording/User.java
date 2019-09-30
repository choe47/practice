package javaCording;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private Date date;

	public User(int idValue, String nameValue, Date dateValue) {
		this.id = idValue;
		this.name = nameValue;
		this.date = dateValue;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getRegisteredDate() {
		return date;
	}
}
