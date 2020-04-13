package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.free.board.service.IFreeBoardService;
import kr.or.ddit.free.board.service.IFreeBoardServiceImpl;
import kr.or.ddit.vo.FBoardVO;

import com.opensymphony.xwork2.Action;

public class FreeboardReplyFormAction implements Action {
	
	private String bo_no;
	private FBoardVO boardInfo;
	
	@Override
	public String execute() throws Exception {
		
		IFreeBoardService service = IFreeBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<>();
		params.put("bo_no", bo_no);
		
		boardInfo = service.freeboardInfo(params);
		
		return SUCCESS;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public FBoardVO getBoardInfo() {
		return boardInfo;
	}

}
