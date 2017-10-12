package kr.or.dgit.jdbc_application.dto;

public class Employee {
	private int empNo;
	private String empName;
	private Title tilte;
	private Employee manager;
	private int salary;
	private Department dno;
	
	public Employee() {
	}
	
	public Employee(int empNo, String empName, Title tilte, Employee manager, int salary, Department dno) {
		this.empNo = empNo;
		this.empName = empName;
		this.tilte = tilte;
		this.manager = manager;
		this.salary = salary;
		this.dno = dno;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public Employee(int empNo) {
		this.empNo = empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Title getTilte() {
		return tilte;
	}
	public void setTilte(Title tilte) {
		this.tilte = tilte;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDno() {
		return dno;
	}
	public void setDno(Department dno) {
		this.dno = dno;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s", empNo, empName,tilte.getTitleNo(), manager.getEmpNo(), salary, dno.getDetptNo());
	}	
}
