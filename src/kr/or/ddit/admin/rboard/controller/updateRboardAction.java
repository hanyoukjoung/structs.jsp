package kr.or.ddit.admin.rboard.controller;

import java.net.URLEncoder;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;
import kr.or.ddit.vo.RBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class updateRboardAction implements Action,ModelDriven<RBoardVO>{
	private RBoardVO rboardInfo;
	private String message;
	
	

	@Override
	public String execute() throws Exception {
		
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		service.updateRBoardInfo(rboardInfo);
		this.message = URLEncoder.encode("게시글이 수정되었습니다.", "UTF-8");
		
		return SUCCESS;
	}
	public RBoardVO getRboardInfo() {
		return rboardInfo;
	}

	public String getMessage() {
		return message;
	}
	@Override
	public RBoardVO getModel() {
		this.rboardInfo = new RBoardVO();
		return rboardInfo;
	}
}
