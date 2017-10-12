package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.content.TitleComtent;
import kr.or.dgit.jdbc_application.dao.DepartMentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;


public class TestMain {
	public static JButton btn = new JButton("테스트");;
	public static void main(String[] args) {

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

//		DBCon dbCon = DBCon.getInstance();	
//		Connection connection = dbCon.getConnection();
//		System.out.println(connection);	
//		testTextFieldConponent();
//		TestDeptConponent();
//		testTitleConponent();
		EmployeeContent etc = new EmployeeContent();
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					etc.isEmptyCheck();
					Employee emp  = etc.getContent();
					JOptionPane.showMessageDialog(null, emp);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}	
			}
		});
		testContent(etc, btn);
		
	}

	private static void testTitleConponent() {
		TitleComtent ttc = new TitleComtent();
		Title t = new Title(1, "사장");
		ttc.setContent(t);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ttc.isEmptyCheck();
					Title t1  = ttc.getContent();
					JOptionPane.showMessageDialog(null, t1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}	
			}
		});
		testContent(ttc, btn);
	}

	private static void TestDeptConponent() {
		DepartmentContent dtc = new DepartmentContent();
		Department dept = new Department(1, "개발", 10);
		dtc.setContent(dept);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dtc.isEmptyCheck();
					Department dept1  = dtc.getContent();
					JOptionPane.showMessageDialog(null, dept1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		testContent(dtc, btn);
	}

	private static void testTextFieldConponent() {
		TextFieldComponent tfc = new TextFieldComponent("테스트");	
		JButton btn = new JButton("테스트");
		tfc.setTextValue("재진");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getTextValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		testContent(tfc, btn);
	}

	private static void testContent(JPanel panel, JButton btn) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 200, 150);
		jf.add(panel);
		jf.add(btn,BorderLayout.SOUTH);
		jf.setVisible(true);

	}
}