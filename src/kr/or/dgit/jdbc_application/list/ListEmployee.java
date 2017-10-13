package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

public class ListEmployee extends AbstractList {

	@Override
	protected void setAlignWidth() {
		setCellWidth(100,100,100,150,150,10);
		setAlign(SwingConstants.CENTER,0,1,2,3,5);
		setAlign(SwingConstants.RIGHT,4);
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"사원번호","사원명","직책","관리자","급여","부서"};
	}

	@Override
	protected Object[][] getData() {
		Object[][] datas= {
				{1,"이성래","사장","","5000000","기획"},
				{2,"조민희","과장","이성래","3000000","개발"},
				{3,"이순신","부장","이순신","4000000","영업"}
		};
		return datas;
	}

	@Override
	public Object getSelectedItem() {
		
		return null;
	}

}
