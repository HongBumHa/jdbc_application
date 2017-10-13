package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ListTitle extends AbstractList {

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1); //센터 정렬 , 타이틀은 컬럼이 2가지 이기떄문에 0,1 -> 2개 전부 선택
		setCellWidth(100,150);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[]{"직책 번호", "직책 명"};
	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {{1,"사장"},{2,"부장"}};
		return data;
	}

	@Override
	public Object getSelectedItem() {
		
		return null;
	}

}
