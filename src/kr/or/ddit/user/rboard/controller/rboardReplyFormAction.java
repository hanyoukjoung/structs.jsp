package kr.or.ddit.user.rboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;
import kr.or.ddit.vo.RBoardVO;

import com.opensymphony.xwork2.Action;

public class rboardReplyFormAction implements Action{
	private String bo_no;
	private RBoardVO rboardInfo;
	
	


	@Override
	public String execute() throws Exception {
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);

		
		rboardInfo = service.rboardInfo(params);
		
		return SUCCESS;
	}


	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}


	public RBoardVO getRboardInfo() {
		return rboardInfo;
	}
	public String getBo_no() {
		return bo_no;
	}


}
