package kr.or.ddit.user.qboard.controller;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;
import kr.or.ddit.vo.QBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateQboardFormAction implements Action, ModelDriven<QBoardVO>{
	private QBoardVO qboardInfo = new QBoardVO();
	private String bo_no;
	
	
	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public QBoardVO getQboardInfo() {
		return qboardInfo;
	}

	@Override
	public String execute() throws Exception {
		
		
		QNABoardService service = QNABoardServiceImpl.getInstance();
		
		service.updateQBoardInfo(qboardInfo);
				
		return SUCCESS;
	}

	@Override
	public QBoardVO getModel() {
		this.qboardInfo = new QBoardVO();
		return qboardInfo;
	}

}
