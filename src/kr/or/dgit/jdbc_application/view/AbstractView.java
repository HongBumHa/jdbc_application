package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;

public abstract class AbstractView extends JFrame{

	private JPanel contentPane;
	private JButton btnDel;
	private JButton btnAdd;

	public AbstractView(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));
		pContent.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");

		btnAdd.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAdd.setToolTipText("");
		pBtn.add(btnAdd);
		
		btnDel = new JButton("취소");

		pBtn.add(btnDel);
		
		AbstractList pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
	}

	protected abstract AbstractList createList();

	protected abstract JPanel createContent();


}
