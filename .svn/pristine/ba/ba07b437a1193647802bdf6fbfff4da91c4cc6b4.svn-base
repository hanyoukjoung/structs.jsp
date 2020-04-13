package kr.or.ddit.admin.qboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;
import kr.or.ddit.vo.QBoardVO;

import com.opensymphony.xwork2.Action;

public class QboardViewAction implements Action {
	
	private String bo_no;
	private QBoardVO boardInfo;
	
	@Override
	public String execute() throws Exception {
		
		QNABoardService service = QNABoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		this.boardInfo = service.qboardInfo(params);
		
		return SUCCESS;
	}

	public QBoardVO getBoardInfo() {
		return boardInfo;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
	
}
