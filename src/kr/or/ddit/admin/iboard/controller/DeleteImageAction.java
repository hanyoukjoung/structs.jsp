package kr.or.ddit.admin.iboard.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.image.board.service.IIMGBoardService;
import kr.or.ddit.image.board.service.IIMGBoardServiceImpl;

import com.opensymphony.xwork2.Action;

public class DeleteImageAction implements Action{
	private String bo_no;
	private String message;
	
	
	@Override
	public String execute() throws Exception {
		
		IIMGBoardService service = IIMGBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		service.deleteBoard(params);
		
		message = URLEncoder.encode("게시글이 삭제 되었습니다.","UTF-8");
		
		
		return SUCCESS;
	}
	
	
	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public String getMessage() {
		return message;
	}
}
