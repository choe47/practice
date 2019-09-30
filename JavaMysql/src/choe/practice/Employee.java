package choe.practice;

public class Employee {

	private int empoyeeId;
	private String empoyeeName;
	private String furigana;
	private int age;
	private String sexes;
	private String belongCompany;
	private String belongTnt;
	private int empoyeeCat;
	private int secondeeId;

	void setEmpoyeeId(int id) {
		empoyeeId = id;
	}

	int getEmpoyeeId() {
		return empoyeeId;
	}

	void setEmpoyeeName(String name) {
		empoyeeName = name;
	}

	String getEmpoyeeName() {
		return empoyeeName;
	}

	void setFurigana(String name) {
		furigana = name;
	}

	String getFurigana() {
		return furigana;
	}

	void setAge(int age) {
		this.age = age;
	}

	int getAge() {
		return age;
	}

	void setSexes(String sex) {
		sexes = sex;
	}

	String getSexes() {
		return sexes;
	}

	void setBelongCompany(String name) {
		belongCompany = name;
	}

	String getBelongCompany() {
		return belongCompany;
	}

	void setBelongTnt(String name) {
		belongTnt = name;
	}

	String getBelongTnt() {
		return belongTnt;
	}

	void setEmpoyeeCat(int cat) {
		empoyeeCat = cat;
	}

	int getEmpoyeeCat() {
		return empoyeeCat;
	}

	void setSecondeeId(int id) {
		secondeeId = id;
	}

	int getSecondeeId() {
		return secondeeId;
	}

}
