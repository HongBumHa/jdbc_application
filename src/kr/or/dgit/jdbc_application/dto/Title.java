package kr.or.dgit.jdbc_application.dto;

public class Title {
	private int titleNo;
	private String titleName;
	
	@Override
	public String toString() {
		return String.format("Title [titleNo=%s, titleName=%s]", titleNo, titleName);
	}
	public Title(){
		
	}
	public Title(int titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
}