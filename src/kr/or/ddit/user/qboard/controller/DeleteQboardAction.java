package kr.or.ddit.user.qboard.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;

import com.opensymphony.xwork2.Action;

public class DeleteQboardAction implements Action {
	
	private String bo_no;
	private String message;
	
	@Override
	public String execute() throws Exception {
		
		QNABoardService service = QNABoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		service.deleteQBoardInfo(params);
		
		this.message = URLEncoder.encode("게시글이 삭제되었습니다.", "UTF-8");
		
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
}
