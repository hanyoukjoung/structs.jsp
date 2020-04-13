package kr.or.ddit.admin.rboard.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;

import com.opensymphony.xwork2.Action;

public class DeleterboardAction implements Action{
	private String bo_no;
	private String message;

	

	@Override
	public String execute() throws Exception {
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		service.deleteRBoardInfo(params);
		
		message= URLEncoder.encode("게시글이 삭제되었습니다", "UTF-8");
		
		return SUCCESS;
	}
	public String getMessage() {
		return message;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

}
