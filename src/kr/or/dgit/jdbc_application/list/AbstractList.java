package kr.or.dgit.jdbc_application.list;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbstractList extends JPanel {
	protected JTable table;

	public AbstractList() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		loadData();
	}

	private void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(),getColumnNames());
		table.setModel(model);		
		setAlignWidth();
	}
	protected abstract void setAlignWidth();

	protected void setCellWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		for(int i =0; i<width.length; i++){
			cModel.getColumn(i).setPreferredWidth(width[i]); //위드의 비율 조정
		}
//		cModel.getColumn(0).setPreferredWidth(100);
//		cModel.getColumn(1).setPreferredWidth(150);
//		cModel.getColumn(2).setPreferredWidth(50);
	}

	protected void setAlign(int align, int...idx) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel(); //테이블에서 컬럼을 가져오기때문에 부서번호, 부서명, 위치 3가지가 들어있다
		for(int i=0; i<idx.length; i++){
			//idx = [0,2]
			cModel.getColumn(i).setCellRenderer(dtcr); //테이블에 정렬
		}
		
	}

	protected abstract String[] getColumnNames();

	protected abstract Object[][] getData();
	
	public abstract Object getSelectedItem();
	
}
