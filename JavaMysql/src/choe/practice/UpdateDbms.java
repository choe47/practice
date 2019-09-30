package choe.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateDbms {
	public List<Employee> getEmployeeInfo(){
		Connection con = null;
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> list = new ArrayList<Employee>();
		try {
			// Databaseに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_kanri?user=root&password=melonjuice&serverTimezone=UTC");
			PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
			ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

			// 検索された行数分ループ
			while(rs.next()) {
				Employee emp = new Employee();
				int empoyeeId = rs.getInt("empoyee_id");
				String empoyeeName = rs.getString("empoyee_name");
				String furigana = rs.getString("furigana");
				int age = rs.getInt("age");
				String sexes = rs.getString("sexes");
				String belongCompany = rs.getString("belong_company");
				String belongTnt = rs.getString("belong_tnt");
				int empoyeeCat = rs.getInt("empoyee_cat");
				int secondeeId = rs.getInt("secondee_id");
				emp.setEmpoyeeId(empoyeeId);
				emp.setEmpoyeeName(empoyeeName);
				emp.setFurigana(furigana);
				emp.setAge(age);
				emp.setSexes(sexes);
				emp.setBelongCompany(belongCompany);
				emp.setBelongTnt(belongTnt);
				emp.setEmpoyeeCat(empoyeeCat);
				emp.setSecondeeId(secondeeId);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}  finally {
			try {
				// close処理
				if(con != null){
					con.close();
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
}

