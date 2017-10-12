package kr.or.dgit.jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartMentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class TestMain {
	
	public static void main(String[] args) {
//		testDBcon();
//		Department dept = new Department(4,"마케팅",10);
//		testInsert(dept);
//		testListAll();		
//		dept.setDeptName("마케팅2");
//		testUpdate(dept);
//		testListAll();
//		testDelete(dept);
//		testListAll();	
//		testDeptNo();
//		Title t = new Title(10,"사장아들");
//		titleInsert(t);	
//		titleListAll();
//		titleListNo(t);
//		t.setTitleName("낙하산");	
//		testUpdate(t);
//		titleListAll();
//		titleDelete(t);
//		titleListAll();
//		Title t = new Title(5);
//		Title t1 = TitleDao.getInstance().selectItemByNo(t);
//		Employee emp = new Employee(1, "하홍범",t1.getTitleNo(),, 1000000, 2);
//		EmployeeDao.getInstance().insertItem(item);
		Employee emp = new Employee(1003);
		try {
			Employee empy = EmployeeDao.getInstance().selectItemByNo(emp);
			System.out.println(empy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void titleListNo(Title t) {
		try {
			Title tt = TitleDao.getInstance().selectItemByNo(t);
			System.out.println("찾은 타이틀명 "+tt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void titleUpdate(Title t) {
		try {
			TitleDao.getInstance().deleteItem(t);
			JOptionPane.showMessageDialog(null, "타이틀이 수정되었습니다");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "타이틀이 수정되지않습니다");
			e.printStackTrace();
		}
	}

	private static void titleListAll() {
		try {
			List<Title> lists= TitleDao.getInstance().selectItemByAll();
			for(Title tt : lists){
				System.out.println(tt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void titleDelete(Title t) {
		try {
			TitleDao.getInstance().deleteItem(t);
			JOptionPane.showMessageDialog(null, "타이틀이 삭제되었습니다");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "타이틀이 삭제되지않았습니다");
			e.printStackTrace();
		}
	}

	private static void titleInsert(Title t) {
		try {
			TitleDao.getInstance().insertItem(t);
			JOptionPane.showMessageDialog(null, "타이틀이 추가되었습니다");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "타이틀이 중복입니다");
			e.printStackTrace();
		}
	}

	private static void testUpdate(Title t) {
		try {
			TitleDao.getInstance().updateItem(t);
			JOptionPane.showMessageDialog(null, "타이틀이 수정되었습니다");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "타이틀이 수정되않습니다");
			e.printStackTrace();
		}
		
	}

	private static void testDeptNo() {
		try {
			Department d =DepartMentDao.getInstance().selectItemByNo(new Department(1));
			System.out.println(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartMentDao.getInstance().selectItemByAll();
			for(Department d : lists){
				System.out.println(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartMentDao.getInstance().deleteItem(dept);
			JOptionPane.showConfirmDialog(null, "부서가 삭제되었습니다");
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + " - " + e.getMessage());
			JOptionPane.showConfirmDialog(null, "삭제 실패하셨습니다");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartMentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서번호가 추가되었습니다");
		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + " - " + e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "부서번호가 중복입니다.");
			}
		}
	}

	private static void testDBcon() {
		DBCon dbCon = DBCon.getInstance();
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
	}
}