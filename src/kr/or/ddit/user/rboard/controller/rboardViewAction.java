package kr.or.ddit.user.rboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;
import kr.or.ddit.vo.RBoardVO;

import com.opensymphony.xwork2.Action;

public class rboardViewAction implements Action{
	private String bo_no;
	
	

	
	private RBoardVO rboardInfo;

	@Override
	public String execute() throws Exception {
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("bo_no", bo_no);
		
		
		rboardInfo = service.rboardInfo(params);
		System.out.println("---------"+ServletActionContext.getRequest().getSession().getAttribute("LOGIN_MEMBERINFO"));
		return SUCCESS;
	}
	
	
	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
	
	public RBoardVO getRboardInfo() {
		return rboardInfo;
	}

}
