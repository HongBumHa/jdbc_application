package kr.or.dgit.jdbc_application.dto;

public class Department {
	private int detptNo;
	private String deptName;
	private int floor;
	
	
	public int getDetptNo() {
		return detptNo;
	}
	public void setDetptNo(int detptNo) {
		this.detptNo = detptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Department(String deptName) {
		this.deptName = deptName;
	}
	public Department(int detptNo, String deptName, int floor) {
		this.detptNo = detptNo;
		this.deptName = deptName;
		this.floor = floor;
	}
	public Department() {
	}
	@Override
	public String toString() {
		return String.format("Department [detptNo=%s, deptName=%s, floor=%s]", detptNo, deptName, floor);
	}
	
}
