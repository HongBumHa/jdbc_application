package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

@SuppressWarnings({ "serial" })
public class EmployeeContent extends JPanel {
	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private JPanel pTitle;
	private JPanel pManager;
	private JPanel pSalary;
	private JPanel panel;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel tCbModel;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel mCbModel;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel dCbModel;
	private SpinnerModel sModel;
	private JSpinner sSalary;
	private JLabel lblDno;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EmployeeContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원 번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원 명");
		add(pEmpName);
		
		pTitle = new JPanel();
		add(pTitle);
		pTitle.setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		pTitle.add(lblTitle);
		tCbModel = new DefaultComboBoxModel(getTitle());
		JComboBox cmbTitle = new JComboBox(tCbModel);
		pTitle.add(cmbTitle);
		
		pManager = new JPanel();
		add(pManager);
		pManager.setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblManager = new JLabel("매니저");
		lblManager.setHorizontalAlignment(SwingConstants.RIGHT);
		pManager.add(lblManager);
		
		mCbModel = new DefaultComboBoxModel(getManager());
		JComboBox cmbManager = new JComboBox(mCbModel);
		pManager.add(cmbManager);
		
		pSalary = new JPanel();
		add(pSalary);
		pSalary.setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblSalary = new JLabel("월급");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		pSalary.add(lblSalary);
		sModel = new SpinnerNumberModel(1500000,1000000,5000000,100000);
		sSalary = new JSpinner(sModel);

		pSalary.add(sSalary);
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 10, 0));
		
		lblDno = new JLabel("부서");
		lblDno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDno);
		
		dCbModel = new DefaultComboBoxModel(getDno());
		JComboBox cmbDno = new JComboBox(dCbModel);
		panel.add(cmbDno);

	}
	private Object[] getDno() {
		
		return new Object[]{"영업(1)","기획(2)","개발(3)","연구(5)"};
	}
	private Object[] getManager() {
		return new Object[]{"이성래","조민희","박영권","이수민"};
	}
	private Object[] getTitle() {
		return new Object[]{"사장","부장","과장","대리","사원"};
	}
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title tilte = new Title(tCbModel.getSelectedItem().toString());
		Employee manager = new Employee(mCbModel.getSelectedItem().toString());
		int salary = Integer.parseInt(sSalary.getValue().toString());
		Department dno = new Department(dCbModel.getSelectedItem().toString());
		return new Employee(empNo, empName, tilte, manager, salary, dno);
	}
	
	public void isEmptyCheck() throws Exception{
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		
	}
}
