package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.free.board.service.IFreeBoardService;
import kr.or.ddit.free.board.service.IFreeBoardServiceImpl;
import kr.or.ddit.vo.FBoardVO;

import com.opensymphony.xwork2.Action;

public class FreeboardViewAction implements Action {
	
	private String bo_no;
	private FBoardVO boardInfo;
	
	@Override
	public String execute() throws Exception {
		
		IFreeBoardService service = IFreeBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		this.boardInfo = service.freeboardInfo(params);
		
		return SUCCESS;
	}

	public FBoardVO getBoardInfo() {
		return boardInfo;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
	
}
