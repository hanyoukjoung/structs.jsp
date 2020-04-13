package kr.or.ddit.user.freeboard.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.free.board.service.IFreeBoardService;
import kr.or.ddit.free.board.service.IFreeBoardServiceImpl;

import com.opensymphony.xwork2.Action;

public class DeleteFreeboardAction implements Action {
	
	private String bo_no;
	private String message;

	@Override
	public String execute() throws Exception {
		
		IFreeBoardService service = IFreeBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		service.deletefreeboard(params);
		
		message = URLEncoder.encode("게시글이 삭제되었습니다.", "UTF-8");
		
		return SUCCESS;
	}
	
	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public String getMessage() {
		return message;
	}
	
}
