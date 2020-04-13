package kr.or.ddit.notify.board.controller;

import java.util.HashMap;
import java.util.Map;



import kr.or.ddit.ntc.board.service.NtcBoardService;
import kr.or.ddit.ntc.board.service.NtcBoardServiceImpl;
import kr.or.ddit.vo.NBoardVO;

import com.opensymphony.xwork2.Action;

public class NotifyViewAction implements Action {
	
	private NBoardVO nboardInfo;
	private String bo_no;
	
	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", this.bo_no);
		
		NtcBoardService service = NtcBoardServiceImpl.getInstance();
		
		this.nboardInfo = service.nboardInfo(params);
		
		return SUCCESS;
	}
	
	public NBoardVO getNboardInfo() {
		return nboardInfo;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
	
}
