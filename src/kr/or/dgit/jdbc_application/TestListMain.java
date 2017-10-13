package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.list.ListTitle;

public class TestListMain {
	
	public static void main(String[] args) {
//		testDept();
//		testTitle();
		
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 300, 450);
		
		AbstractList ld = new ListDepartment();
		jf.add(ld);
		jf.setVisible(true);
		
		JButton btn = new JButton("test");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = ld.getSelectedItem();		
				JOptionPane.showMessageDialog(null, obj);
			}
		});
		jf.add(btn,BorderLayout.SOUTH);
	}

	private static void testTitle() {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 300, 450);
		
		AbstractList ld = new ListTitle();
		jf.add(ld);
		jf.setVisible(true);
	}

	private static void testDept() {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 300, 450);
		
		AbstractList ld = new ListDepartment();
		jf.add(ld);
		jf.setVisible(true);
	}
}
