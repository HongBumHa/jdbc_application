package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class TitleComtent extends JPanel {
	private TextFieldComponent pTitleName;
	private TextFieldComponent pTitleNo;

	public TitleComtent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleNo = new TextFieldComponent("직책 번호");
		add(pTitleNo);
		
		pTitleName = new TextFieldComponent("직책");
		add(pTitleName);
	}
	
	public Title getContent(){
		int titleNo = Integer.parseInt(pTitleNo.getTextValue());
		String titleName = pTitleName.getTextValue();
		return new Title(titleNo, titleName);
	}
	
	public void setContent(Title t){
		pTitleNo.setTextValue(t.getTitleNo() + "");
		pTitleName.setTextValue(t.getTitleName());
	}
	
	public void isEmptyCheck() throws Exception{
		pTitleNo.isEmptyCheck();
		pTitleName.isEmptyCheck();
	}

}
