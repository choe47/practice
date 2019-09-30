package choe.practice;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ConnectDbms dbms = new ConnectDbms();

		Employee empl = new Employee();
		empl.setEmpoyeeId(23);
		empl.setEmpoyeeName("\"佐藤夏男\"");
		empl.setFurigana("\"furigana\"");
		empl.setAge(34);
		empl.setSexes("\"女\"");
		empl.setBelongCompany("\"belongCompany\"");
		empl.setBelongTnt("\"belongTnt\"");
		empl.setEmpoyeeCat(3);
		empl.setSecondeeId(2);
		dbms.addEmployee(empl);

		List<Employee> list = dbms.getEmployeeInfo();
		for (Employee emp : list) {
			System.out.println(
					emp.getEmpoyeeId() + "," + emp.getEmpoyeeName() + ","
							+ emp.getAge() + "," + emp.getSexes());
		}

		// List<Employee> empl = new ArrayList<Employee>();

		// empl =
		// 23,佐藤夏男,SATONAO,34,女,belong_company,belong_tnt,empoyee_cat,secondee_id;

	}
}
