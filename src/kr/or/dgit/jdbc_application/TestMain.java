package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.content.TitleComtent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class TestMain {
	public static JButton btn = new JButton("테스트");;
	public static void main(String[] args) {
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