package kr.or.ddit.user.qboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;
import kr.or.ddit.vo.QBoardVO;

import com.opensymphony.xwork2.Action;

public class QboardViewAction implements Action{
	private QBoardVO qboardInfo;
	private String bo_no;

	public QBoardVO getQboardInfo() {
		return qboardInfo;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String,  String>();
		params.put("bo_no", bo_no);
		
		QNABoardService service = QNABoardServiceImpl.getInstance();
		
		this.qboardInfo = service.qboardInfo(params);
		
		return SUCCESS;
	}

}
